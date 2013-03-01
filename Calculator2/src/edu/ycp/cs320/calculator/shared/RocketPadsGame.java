package edu.ycp.cs320.calculator.shared;

public class RocketPadsGame 
{
	// Fields
	RocketPadsLocation win_zone; 
	final int LENGTH = 900, WIDTH = 900;
	boolean win; // When true, game ends.
	
	// Constructor
	RocketPadsGame()
	{
		win_zone = new RocketPadsLocation(450,450);
		win = false;
	}
	
	public int checkVictory(RocketPadsPlayer player)
	{
		return player.getLocation().compareLocTo(win_zone);
	}
}
