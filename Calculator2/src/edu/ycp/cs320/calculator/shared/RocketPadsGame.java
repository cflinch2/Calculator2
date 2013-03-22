package edu.ycp.cs320.calculator.shared;

import java.util.ArrayList;
/*
NORTH 1
SOUTH 2
EAST 3
WEST 4
WALK 5
STOP 6
WIN 7
*/

public class RocketPadsGame 
{
	// Fields
	RocketPadsLocation win_zone; 
	final int LENGTH = 900, WIDTH = 900;
	boolean win; // When true, game ends.
	ArrayList<RocketPadsPlayer> players;
	private int[][] board1 = {{6,3,3,3,3,2,2,6,4,4,4,6},
							  {2,6,4,4,6,4,2,3,3,6,4,2},
							  {2,3,2,1,3,2,2,1,2,4,1,2},
							  {6,1,2,1,4,2,3,1,4,1,1,2},
							  {2,1,2,3,1,4,2,6,3,1,1,2},
							  {3,1,6,3,3,7,7,3,3,1,1,4},
							  {3,3,3,3,2,7,7,4,4,4,4,4},
							  {1,3,6,2,2,1,3,3,2,4,4,6},
							  {1,1,2,2,2,1,1,3,2,3,1,1},
							  {1,1,2,2,6,1,1,1,2,6,3,1},
							  {6,1,2,6,3,2,1,1,2,1,4,4},
							  {6,4,4,4,4,4,1,6,4,4,4,6}};
	
	// Constructor
	public RocketPadsGame(int num_players)
	{
		win_zone = new RocketPadsLocation(LENGTH/2,WIDTH/2);
		win = false;
		players = new ArrayList<RocketPadsPlayer>();
		
		for(int i = 0; i < num_players; i ++)
		{
			players.add(new RocketPadsPlayer());
		}
	}
	
	public int checkVictory(RocketPadsPlayer player)
	{
		return player.getLocation().compareLocTo(win_zone);
	}
}
