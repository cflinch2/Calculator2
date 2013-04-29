package edu.ycp.cs320.calculator.shared;

public class RocketPadsCreateBoardDataFromArray {

	public static RocketPadsBoardData createFromArray(int[][] arr, BoardList board) {
		RocketPadsBoardData boardData = new RocketPadsBoardData();
		
		boardData.setBoard(board);
		
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
 		case 5:
 			return RocketPadsDirection.STOP;
 		case 6:
 			return RocketPadsDirection.START;
 		case 7:
 			return RocketPadsDirection.WIN;
 		default:
 			return RocketPadsDirection.STOP;
		}
	}
}
