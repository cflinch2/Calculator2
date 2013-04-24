package edu.ycp.cs320.calculator.shared;

public class RocketPadsPlayer 
{
	// Fields
	private RocketPadsLocation start, current;
	private RocketPadsDirection dir;
	
	// Constructor
	public RocketPadsPlayer(RocketPadsLocation start_loc, RocketPadsDirection start_dir)
	{
		start = start_loc;
		current = start;
		dir = start_dir;
	}
	
	// Resets the player's location to his starting location.
	public void reset_location()
	{
		current.setX(start.getX());
		current.setY(start.getY());
	}
	
	public RocketPadsLocation getLocation()
	{
		return current;
	}
	
	public void setLocation(int x, int y)
	{
		current = new RocketPadsLocation(x,y);
	}
	
	public RocketPadsDirection getDirection()
	{
		return dir;
	}
	
	public void setDirection(RocketPadsDirection direction) {
		dir = direction;
	}
}
