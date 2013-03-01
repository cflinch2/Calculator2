package edu.ycp.cs320.calculator.shared;

import java.util.ArrayList;

public class RocketPadsGame 
{
	// Fields
	RocketPadsLocation win_zone; 
	final int LENGTH = 900, WIDTH = 900;
	boolean win; // When true, game ends.
	ArrayList<RocketPadsPlayer> players;
	
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
