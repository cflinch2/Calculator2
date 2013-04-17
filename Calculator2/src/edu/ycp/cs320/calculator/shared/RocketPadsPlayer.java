package edu.ycp.cs320.calculator.shared;

public class RocketPadsPlayer 
{
	// Fields
	private RocketPadsLocation start, current;
	private RocketPadsDirection dir;
	
	// Constructor
	public RocketPadsPlayer()
	{
		start = new RocketPadsLocation(0,0);
		current = new RocketPadsLocation(0,0);
		dir = RocketPadsDirection.START_RED;
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
