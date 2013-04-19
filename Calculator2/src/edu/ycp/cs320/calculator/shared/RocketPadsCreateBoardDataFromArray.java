package edu.ycp.cs320.calculator.shared;

public class RocketPadsCreateBoardDataFromArray {

	public static RocketPadsBoardData createFromArray(int[][] arr) {
		RocketPadsBoardData boardData = new RocketPadsBoardData();
		
		for (int j = 0; j < RocketPadsGame.BOARD_HEIGHT; j++) {
			for (int i = 0; i < RocketPadsGame.BOARD_WIDTH; i++) {
				boardData.setPad(i, j, fromInt(arr[j][i]));
			}
		}
		
		return boardData;
	}
	
	private static RocketPadsDirection fromInt(int value) {
		switch(value) {
		case 1:
			return RocketPadsDirection.NORTH;
		case 2:
			return RocketPadsDirection.SOUTH;
		case 3:
			return RocketPadsDirection.EAST;
		case 4:
			return RocketPadsDirection.WEST;
 		case 6:
 			return RocketPadsDirection.STOP;
 		case 8:
 			return RocketPadsDirection.START_RED;
 		case 9:
 			return RocketPadsDirection.START_BLUE;
 		case 10:
 			return RocketPadsDirection.START_GREEN;
 		case 11:
 			return RocketPadsDirection.START_YELLOW;
 		case 12:
 			return RocketPadsDirection.WIN;
 		default:
 			return RocketPadsDirection.STOP;
		}
	}
}
