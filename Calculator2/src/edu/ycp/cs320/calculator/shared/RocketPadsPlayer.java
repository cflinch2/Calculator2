package edu.ycp.cs320.calculator.shared;

public class RocketPadsPlayer 
{
	// Fields
	private RocketPadsLocation start, current;
	private RocketPadsDirection dir;
	private boolean slide; // Determines if the player is currently sliding (in which case manual controls are disabled).
	
	// Constructor
	public RocketPadsPlayer()
	{
		start = new RocketPadsLocation(0,0);
		current = new RocketPadsLocation(0,0);
		dir = RocketPadsDirection.WALK;
		slide = false;
	}
	
	// Resets the player's location to his starting location.
	public void reset_location()
	{
		current.setX(start.getX());
		current.setY(start.getY());
	}
	
	//should this really be "RocketPadsLocation getLocation()"?
	public RocketPadsLocation getLocation()
	{
		return current;
	}
	
	public void setLocation(int x, int y)
	{
		current = new RocketPadsLocation(x,y);
	}
	
	public boolean getSlide()
	{
		return slide;
	}
	
	public void setSlide(boolean s)
	{
		slide = s;
	}
	
	public RocketPadsDirection getDirection()
	{
		return dir;
	}
	
	public void setDirection(int direction) {
		if(direction == 1) {
			this.dir = RocketPadsDirection.NORTH;
		}
		
		else if(direction == 2) {
			this.dir = RocketPadsDirection.SOUTH;
		}
		
		else if(direction == 3) {
			this.dir = RocketPadsDirection.EAST;
		}
		
		else if(direction == 4) {
			this.dir = RocketPadsDirection.WEST;
		}
		
		else if(direction == 5) {
			this.dir = RocketPadsDirection.WALK;
		}
		else if(direction == 6) {
			this.dir = RocketPadsDirection.STOP;
		}
	}
	

}
