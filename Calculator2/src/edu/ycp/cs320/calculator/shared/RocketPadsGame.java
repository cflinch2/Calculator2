package edu.ycp.cs320.calculator.shared;

import java.util.ArrayList;

public class RocketPadsGame 
{
	public static final int WIDTH = 900;
	public static final int HEIGHT = 900;
	public static final int BOARD_WIDTH = 12;
	public static final int BOARD_HEIGHT = 12;
	
	private RocketPadsBoardData board; // Stores the dynamic board data.
	
	private boolean win;
	
	private ArrayList<RocketPadsPlayer> players;
	
	// Player start locations.
	private RocketPadsLocation red_player_start;
	private RocketPadsLocation blue_player_start;
	private RocketPadsLocation green_player_start;
	private RocketPadsLocation yellow_player_start;

	public RocketPadsGame(int num_players, RocketPadsBoardData board)
	{
		win = false;
		
		this.board = board;
		
		for (int j = 0; j < BOARD_HEIGHT; j++) {
			for (int i = 0; i < BOARD_WIDTH; i++) {
				switch(board.getPad(i,j)) {
				case START_RED:
					red_player_start = new RocketPadsLocation(i*75, j*75);
					break;
				case START_BLUE:
					blue_player_start = new RocketPadsLocation(i*75, j*75);
					break;
				case START_GREEN:
					green_player_start = new RocketPadsLocation(i*75, j*75);
					break;
				case START_YELLOW:
					yellow_player_start = new RocketPadsLocation(i*75, j*75);
					break;
				default:
					break;
				}
			}
		}
		
		players = new ArrayList<RocketPadsPlayer>();
		
		// Constructs the list of players for the current game and initializes their starting locations and directions.
		for(int i = 0; i < num_players; i++)
		{
			if(i == 0) {
				players.add(new RocketPadsPlayer(red_player_start, RocketPadsDirection.START_RED));
			} else if(i == 1) {
				players.add(new RocketPadsPlayer(blue_player_start, RocketPadsDirection.START_BLUE));
			}
			else if(i == 2) {
				players.add(new RocketPadsPlayer(green_player_start, RocketPadsDirection.START_GREEN));
			}
			else if(i == 3) {
				players.add(new RocketPadsPlayer(yellow_player_start, RocketPadsDirection.START_YELLOW));
			}
		}
	}
	
	public RocketPadsLocation getRedStartLocation() {
		return red_player_start;
	}
	
	public RocketPadsLocation getBluePlayerLocation() {
		return blue_player_start;
	}
	
	public RocketPadsLocation getGreenPlayerLocation() {
		return green_player_start;
	}
	
	public RocketPadsLocation getYellowPlayerLocation() {
		return yellow_player_start;
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
