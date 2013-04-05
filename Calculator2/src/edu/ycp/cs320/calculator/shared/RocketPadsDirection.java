package edu.ycp.cs320.calculator.shared;

public enum RocketPadsDirection 
{
	NORTH,	//1
	SOUTH,	//2
	EAST,	//3
	WEST,	//4
	WALK,	//5
	STOP,	//6
	WIN;	//7
	
	public String toString() {
		if(this == NORTH)
			return "north";
		else if(this == SOUTH)
			return "south";
		else if(this == EAST)
			return "east";
		else if(this == WEST)
			return "west";
		else if(this == WALK)
			return "walk";
		else if(this == STOP)
			return "stop";
		else if(this == WIN)
			return "win";
		return null;
	}
}
