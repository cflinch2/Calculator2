package edu.ycp.cs320.calculator.shared;

public class RocketPadsGame 
{
	public static final int WIDTH = 900;
	public static final int HEIGHT = 900;
	public static final int BOARD_WIDTH = 12;
	public static final int BOARD_HEIGHT = 12;
	
	private RocketPadsBoardData board; // Stores the dynamic board data.
	
	private boolean win;
	private int num_players;
	private RocketPadsPlayer player;
	
	// Player start locations.
	private RocketPadsLocation player_start;

	public RocketPadsGame(RocketPadsBoardData board_data)
	{
		// Initialize win condition to false.
		win = false;
		
		num_players = 1;
		
		// Assign board data.
		board = board_data;
		
		// Acquires the values for each starting location.
		for (int j = 0; j < BOARD_HEIGHT; j++) {
			for (int i = 0; i < BOARD_WIDTH; i++) {
				switch(board.getPad(i,j)) {
				case START:
					player_start = new RocketPadsLocation(i*75, j*75);
					break;
				default:
					player_start = new RocketPadsLocation(0,0);
					break;
				}
			}
		}
		
		// Create player.
		player = new RocketPadsPlayer(player_start, RocketPadsDirection.START);
	}

	public int get_num_players() {
		return num_players;
	}
	
	public RocketPadsPlayer getPlayer() {
		return player;
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
