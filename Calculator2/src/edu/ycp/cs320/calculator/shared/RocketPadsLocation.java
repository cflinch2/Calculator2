package edu.ycp.cs320.calculator.shared;

public class RocketPadsLocation 
{
	private int x, y;
	
	public RocketPadsLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	// Compares this location to the argument location. If they are the same, returns 1. Otherwise, returns -1.
	public int compareLocTo(RocketPadsLocation location)
	{
		if(this.x == location.x && this.y == location.y)
			return 1;
		else
			return -1;
	}
}
