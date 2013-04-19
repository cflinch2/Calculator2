package edu.ycp.cs320.calculator.shared;

import java.util.ArrayList;

public class RocketPadsGame 
{
	// Fields
	public static final int WIDTH = 900;
	public static final int HEIGHT = 900;

	public static final int BOARD_WIDTH = 12;
	public static final int BOARD_HEIGHT = 12;

	public static final RocketPadsLocation START_RED = new RocketPadsLocation(0,0);
	public static final RocketPadsLocation START_BLUE = new RocketPadsLocation(11*75,0);
	public static final RocketPadsLocation START_GREEN = new RocketPadsLocation(0,11*75);
	public static final RocketPadsLocation START_YELLOW = new RocketPadsLocation(11*75,11*75);
	
	private RocketPadsBoardData board;
	private boolean win; // When true, game ends.
	private ArrayList<RocketPadsPlayer> players;
	
	private int[][] board1 = {{8,3,3,3,3,2,2,6,4,4,4,9},
							  {2,6,4,4,6,4,2,3,3,6,4,2},
							  {2,3,2,1,3,2,3,1,2,4,1,2},
							  {6,1,2,1,4,2,1,2,4,1,1,2},
							  {2,1,2,3,1,4,2,6,3,1,1,2},
							  {3,1,6,3,3,12,12,3,3,1,1,4},
							  {3,3,3,3,2,12,12,4,4,4,4,4},
							  {1,3,6,2,2,1,3,3,2,4,4,6},
							  {1,1,2,2,2,1,1,3,2,3,1,1},
							  {1,1,2,2,6,1,1,1,2,6,3,1},
							  {6,1,2,6,3,2,1,1,2,1,4,4},
							  {10,4,4,4,4,4,1,6,4,4,4,11}};
	
	private int[][] board2 = {{8,2,2,6,4,4,6,4,4,4,2,9},
								{3,3,3,2,6,1,2,3,3,3,6,2},
								{2,6,3,6,2,1,3,1,2,4,4,2},
								{2,1,1,4,2,1,2,4,3,6,1,6},
								{2,1,4,4,4,1,2,1,6,2,1,2},
								{3,6,3,3,3,12,12,1,1,4,6,4},
								{3,1,3,3,3,12,12,4,2,2,4,6},
								{1,3,2,1,3,1,3,1,4,4,1,1},
								{1,4,2,1,1,4,1,3,3,2,6,4},
								{3,6,4,1,1,4,6,1,1,4,3,1},
								{1,1,1,3,6,1,1,1,3,3,1,4},
								{10,3,3,1,3,1,1,6,4,4,4,11}};
	
	private int[][] board3 = {{8,4,2,6,3,3,6,6,4,4,4,9},
								{2,1,2,3,1,4,4,3,3,2,2,1},
								{2,1,4,1,2,2,4,4,4,2,3,1},
								{6,3,3,1,2,2,3,3,1,2,2,4},
								{2,2,6,4,2,3,2,3,6,4,2,1},
								{2,3,2,1,3,12,12,1,4,2,4,1},
								{3,6,3,1,1,12,12,4,2,4,2,6},
								{2,4,3,3,1,1,4,1,2,3,2,1},
								{3,3,1,3,2,3,1,1,3,6,2,1},
								{3,3,3,6,4,6,4,1,4,4,2,1},
								{1,1,4,4,1,2,1,4,2,4,4,1},
								{10,3,3,3,3,3,3,1,3,3,3,11}};

	public RocketPadsGame(int num_players)
	{
		win = false;
		
		players = new ArrayList<RocketPadsPlayer>();
		
		for(int i = 0; i < num_players; i ++)
		{
			players.add(new RocketPadsPlayer());
		}
		
		board = RocketPadsCreateBoardDataFromArray.createFromArray(board1);
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
		return board.getPad(col, row);
	}
	
	public void setWin(boolean win) {
		this.win = win;
	}
	
	public boolean checkWin() {
		return win;
	}
}
