package edu.ycp.cs320.calculator.shared;

public enum RocketPadsDirection 
{
	NORTH,	//1
	SOUTH,	//2
	EAST,	//3
	WEST,	//4
	WALK,	//5
	STOP,	//6
	
	WIN_DO_NOT_USE_THIS, // 7
	
	START_RED,     // 8
	START_BLUE,    // 9
	START_GREEN,   // 10
	START_YELLOW,  // 11
	
	WIN_RED,     // 12
	WIN_BLUE,    // 13
	WIN_GREEN,   // 14
	WIN_YELLOW,  // 15
	;
	
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
		return null;
	}
}
