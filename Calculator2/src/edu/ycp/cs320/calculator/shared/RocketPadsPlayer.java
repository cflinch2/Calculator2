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
	
	public void setDirection(int direction)		
	/*
	NORTH,	1
	SOUTH,	2
	EAST,	3
	WEST,	4
	WALK,	5
	STOP,	6
	WIN;	7
	*/
	{
		if (direction == 1)
		{
			this.dir = RocketPadsDirection.NORTH;
		}
		
		if (direction == 2)
		{
			this.dir = RocketPadsDirection.SOUTH;
		}
		
		if (direction == 3)
		{
			this.dir = RocketPadsDirection.EAST;
		}
		
		if (direction == 4)
		{
			this.dir = RocketPadsDirection.WEST;
		}
		
		if (direction == 5)
		{
			this.dir = RocketPadsDirection.WALK;
		}
		
		if (direction == 6)
		{
			this.dir = RocketPadsDirection.STOP;
		}
		
		if (direction == 7)
		{
			this.dir = RocketPadsDirection.WIN;
		}
	}
	
	
	// Updates the player's position.
	//Isn't this the same as setLocation?
	public void updatePosition()
	{
		if (getSlide() == true)
		{
			if (dir == RocketPadsDirection.NORTH)
			{
				//y decreases
				current.setY(current.getY() -1);
			}
			
			if (dir == RocketPadsDirection.SOUTH)
			{
				//y increases
				current.setY(current.getY() +1);
			}
			
			if (dir == RocketPadsDirection.EAST)
			{
				//x increases
				current.setX(current.getX() +1);
			}
			
			if (dir == RocketPadsDirection.WEST)
			{
				//x decreases
				current.setX(current.getX() -1);
			}
		}
	}
}
