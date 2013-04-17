package edu.ycp.cs320.calculator.shared;

import java.util.ArrayList;

public class RocketPadsGame 
{
	// Fields
	public static final int WIDTH = 900;
	public static final int HEIGHT = 900;
	
	public static final RocketPadsLocation START_RED = new RocketPadsLocation(0,0);
	public static final RocketPadsLocation START_BLUE = new RocketPadsLocation(11,0);
	public static final RocketPadsLocation START_GREEN = new RocketPadsLocation(0,11);
	public static final RocketPadsLocation START_YELLOW = new RocketPadsLocation(11,11);
	
	private boolean win; // When true, game ends.
	private ArrayList<RocketPadsPlayer> players;
	
	private int[][] board1 = {{8,3,3,3,3,2,2,6,4,4,4,9},
							  {2,6,4,4,6,4,2,3,3,6,4,2},
							  {2,3,2,1,3,2,2,1,2,4,1,2},
							  {6,1,2,1,4,2,3,1,4,1,1,2},
							  {2,1,2,3,1,4,2,6,3,1,1,2},
							  {3,1,6,3,3,12,12,3,3,1,1,4},
							  {3,3,3,3,2,12,12,4,4,4,4,4},
							  {1,3,6,2,2,1,3,3,2,4,4,6},
							  {1,1,2,2,2,1,1,3,2,3,1,1},
							  {1,1,2,2,6,1,1,1,2,6,3,1},
							  {6,1,2,6,3,2,1,1,2,1,4,4},
							  {10,4,4,4,4,4,1,6,4,4,4,11}};
	
	private RocketPadsDirection[][] board = new RocketPadsDirection[12][12];

	public RocketPadsGame(int num_players)
	{
		win = false;
		players = new ArrayList<RocketPadsPlayer>();
		
		for(int i = 0; i < num_players; i ++)
		{
			players.add(new RocketPadsPlayer());
		}

		RocketPadsDirection[] values = RocketPadsDirection.values();
		for (int j = 0; j < 12; j++) {
			for (int i = 0; i < 12; i++) {
				int ordinal = board1[j][i] - 1;
				board[j][i] = values[ordinal];
			}
		}
	}
	
	public ArrayList<RocketPadsPlayer> getPlayerList() {
		return players;
	}
	
	public RocketPadsPlayer getPlayer(int num) {
		return players.get(num-1);
	}
	
	public int getBoardWidth() {
		return 12;
	}
	
	public int getBoardHeight() {
		return 12;
	}
	
	public RocketPadsDirection getPad(int col, int row) {
		int num = board1[row][col];
		
		switch(num) {
		case 1:
			return RocketPadsDirection.NORTH;
		case 2:
			return RocketPadsDirection.SOUTH;
		case 3:
			return RocketPadsDirection.EAST;
		case 4:
			return RocketPadsDirection.WEST;
 		case 6:
 			return RocketPadsDirection.STOP;
 		case 8:
 			return RocketPadsDirection.START_RED;
 		case 9:
 			return RocketPadsDirection.START_BLUE;
 		case 10:
 			return RocketPadsDirection.START_GREEN;
 		case 11:
 			return RocketPadsDirection.START_YELLOW;
 		case 12:
 			return RocketPadsDirection.WIN;
 		default:
 			return RocketPadsDirection.STOP;
		}
	}
	
	public void setWin(boolean win) {
		this.win = win;
	}
	
	public boolean checkWin() {
		return win;
	}
}
