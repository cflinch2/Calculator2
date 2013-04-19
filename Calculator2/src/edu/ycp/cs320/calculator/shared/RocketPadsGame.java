package edu.ycp.cs320.calculator.shared;

import java.util.ArrayList;

public class RocketPadsGame 
{
	public static final int WIDTH = 900;
	public static final int HEIGHT = 900;
	public static final int BOARD_WIDTH = 12;
	public static final int BOARD_HEIGHT = 12;

	// The start locations for each player.
	public static RocketPadsLocation START_RED;
	public static RocketPadsLocation START_BLUE;
	public static RocketPadsLocation START_GREEN;
	public static RocketPadsLocation START_YELLOW;
	
	private RocketPadsBoardData board; // Stores the dynamic board data.
	
	private boolean win;
	
	private ArrayList<RocketPadsPlayer> players; // Tracks each of the players.

	public RocketPadsGame(int num_players)
	{
		win = false;
		
		players = new ArrayList<RocketPadsPlayer>();
		
		for(int i = 0; i < num_players; i ++)
		{
			players.add(new RocketPadsPlayer());
		}
	}
	
	public void setBoard(RocketPadsBoardData board) {
		this.board = board;
	}
	
	public ArrayList<RocketPadsPlayer> getPlayerList() {
		return players;
	}
	
	public RocketPadsPlayer getPlayer(int num) {
		return players.get(num-1);
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
