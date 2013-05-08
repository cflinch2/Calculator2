package edu.ycp.cs320.calculator.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.ycp.cs320.calculator.shared.AvatarList;
import edu.ycp.cs320.calculator.shared.BoardList;
import edu.ycp.cs320.calculator.shared.IDatabase;
import edu.ycp.cs320.calculator.shared.RocketPadsBoardData;
import edu.ycp.cs320.calculator.shared.RocketPadsCreateBoardDataFromArray;
import edu.ycp.cs320.calculator.shared.User;

public class DerbyDatabase implements IDatabase {
	private static final String DATASTORE = "H:/rocketpads.db";
	
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new RuntimeException("Could not load Derby JDBC driver");
		}
	}
	
	private class DatabaseConnection {
		public Connection conn;
		public int refCount;
	}
	
	private final ThreadLocal<DatabaseConnection> connHolder = new ThreadLocal<DatabaseConnection>();
	
	private DatabaseConnection getConnection() throws SQLException {
		DatabaseConnection dbConn = connHolder.get();
		if (dbConn == null) {
			dbConn = new DatabaseConnection();
			dbConn.conn = DriverManager.getConnection("jdbc:derby:" + DATASTORE + ";create=true");
			dbConn.refCount = 0;
			connHolder.set(dbConn);
		}
		dbConn.refCount++;
		return dbConn;
	}
	
	private void releaseConnection(DatabaseConnection dbConn) throws SQLException {
		dbConn.refCount--;
		if (dbConn.refCount == 0) {
			try {
				dbConn.conn.close();
			} finally {
				connHolder.set(null);
			}
		}
	}
	
	private<E> E databaseRun(ITransaction<E> transaction) throws SQLException {
		// FIXME: retry if transaction times out due to deadlock
		
		DatabaseConnection dbConn = getConnection();
		
		try {
			boolean origAutoCommit = dbConn.conn.getAutoCommit();
			try {
				dbConn.conn.setAutoCommit(false);

				E result = transaction.run(dbConn.conn);
				dbConn.conn.commit();
				return result;
			} finally {
				dbConn.conn.setAutoCommit(origAutoCommit);
			}
		} finally {
			releaseConnection(dbConn);
		}
	}
	
	void createTables() throws SQLException {
		databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run(Connection conn) throws SQLException {
				
				PreparedStatement stmt = null;
				
				try {
					stmt = conn.prepareStatement(
							"create table board_data (" +
							"  name VARCHAR(100) NOT NULL, " +
							"  data VARCHAR(144) NOT NULL, " +
							"  PRIMARY KEY (name)" +
							")"
					);
					
					stmt.executeUpdate();
					
				} finally {
					DBUtil.closeQuietly(stmt);
				}
				
				return true;
			}
		});
	}
	
	void createInitialData() throws SQLException {
		databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet keys = null;
				
				try {
					stmt = conn.prepareStatement("insert into board_data(name, data) values(?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
					
					String tutorialData = encodeBoardData(FakeDatabase.tutorial);
					stmt.setString(1, BoardList.Tutorial.toString());
					stmt.setString(2, tutorialData);
					stmt.addBatch();
					
					// TODO: other boards
					String level2Data = encodeBoardData(FakeDatabase.level_2);
					stmt.setString(1, BoardList.Level_2.toString());
					stmt.setString(2, level2Data);
					stmt.addBatch();
					
					String level3Data = encodeBoardData(FakeDatabase.level_3);
					stmt.setString(1, BoardList.Level_3.toString());
					stmt.setString(2, level3Data);
					
					stmt.executeBatch();
				
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(keys);
				}
				
				return true;
			}
		});
		
	}
	
	private String encodeBoardData(int[][] tutorial) {
		StringBuffer buf = new StringBuffer();
		
		for (int j = 0; j < tutorial.length; j++) {
			int[] row = tutorial[j];
			for (int i = 0; i < row.length; i++) {
				char c = encodeAsChar(row[i]);
				buf.append(c);
			}
		}
		
		return buf.toString();
	}

	private char encodeAsChar(int i) {
		if (i >= 0 && i <= 9) {
			return (char) ('0' + i);
		} else {
			throw new IllegalArgumentException("Don't know how to encode integer board value " + i + " as character");
		}
	}

	@Override
	public RocketPadsBoardData getBoardData(final BoardList board) {
		try {
			return databaseRun(new ITransaction<RocketPadsBoardData>() {
				@Override
				public RocketPadsBoardData run(Connection conn) throws SQLException {
					PreparedStatement stmt = null;
					ResultSet resultSet = null;
					
					try {
						stmt = conn.prepareStatement("select board_data.data from board_data where name = ?");
						stmt.setString(1, board.toString());
						
						resultSet = stmt.executeQuery();
						
						if (!resultSet.next()) {
							return null;
						}
						
						String encodedBoardData = resultSet.getString(1);
						
						int[][] boardArr = decodeBoardData(encodedBoardData);
						
						return RocketPadsCreateBoardDataFromArray.createFromArray(boardArr, board);
					} finally {
						DBUtil.closeQuietly(stmt);
						DBUtil.closeQuietly(resultSet);
					}
				}
			});
		} catch (SQLException e) {
			throw new RuntimeException("SQLException getting board data", e);
		}
	}
	
	protected int[][] decodeBoardData(String encodedBoardData) {
		if (encodedBoardData.length() != 144) {
			throw new IllegalArgumentException("Board data is wrong length: " + encodedBoardData);
		}
		
		int[][] arr = new int[12][12];
		for (int j = 0; j < 12; j++) {
			for (int i = 0; i < 12; i++) {
				arr[j][i] = decodeChar(encodedBoardData.charAt(j*12 + i));
			}
		}
		
		return arr;
	}

	private int decodeChar(char c) {
		if (c >= '0' && c <= '9') {
			return c - '0';
		} else {
			throw new IllegalStateException("Don't know how to decode " + c);
		}
	}

	@Override
	public User createUser(int id, String username, String password,
			AvatarList avatar) {
		
		return null;
	}
}
