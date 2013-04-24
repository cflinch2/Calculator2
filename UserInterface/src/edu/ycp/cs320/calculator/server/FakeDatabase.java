package edu.ycp.cs320.calculator.server;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.calculator.shared.BoardList;
import edu.ycp.cs320.calculator.shared.IDatabase;
import edu.ycp.cs320.calculator.shared.RocketPadsBoardData;
import edu.ycp.cs320.calculator.shared.RocketPadsCreateBoardDataFromArray;

public class FakeDatabase implements IDatabase {
	private List<RocketPadsBoardData> boardDataList;

	private int[][] board1 = {{8,3,3,3,3,2,2,6,4,4,4,9},
			{2,6,4,4,6,4,2,3,3,6,4,2},
			{2,3,2,1,3,2,3,1,2,4,1,2},
			{6,1,2,1,4,2,1,2,4,1,1,2},
			{2,1,2,3,1,4,2,6,3,1,1,2},
			{3,1,6,3,3,12,12,3,3,1,1,4},
			{3,3,3,3,2,12,12,4,4,4,4,4},
			{1,3,6,2,2,1,3,3,2,4,4,6},
			{1,1,2,2,2,1,1,3,2,3,1,1},
			{1,1,2,2,6,1,1,1,2,6,3,1},
			{6,1,2,6,3,2,1,1,2,1,4,4},
			{10,4,4,4,4,4,1,6,4,4,4,11}};

	private int[][] board2 = {{8,2,2,6,4,4,6,4,4,4,2,9},
			{3,3,3,2,6,1,2,3,3,3,6,2},
			{2,6,3,6,2,1,3,1,2,4,4,2},
			{2,1,1,4,2,1,2,4,3,6,1,6},
			{2,1,4,4,4,1,2,1,6,2,1,2},
			{3,6,3,3,3,12,12,1,1,4,6,4},
			{3,1,3,3,3,12,12,4,2,2,4,6},
			{1,3,2,1,3,1,3,1,4,4,1,1},
			{1,4,2,1,1,4,1,3,3,2,6,4},
			{3,6,4,1,1,4,6,1,1,4,3,1},
			{1,1,1,3,6,1,1,1,3,3,1,4},
			{10,3,3,1,3,1,1,6,4,4,4,11}};

	private int[][] board3 = {{8,4,2,6,3,3,6,6,4,4,4,9},
			{2,1,2,3,1,4,4,3,3,2,2,1},
			{2,1,4,1,2,2,4,4,4,2,3,1},
			{6,3,3,1,2,2,3,3,1,2,2,4},
			{2,2,6,4,2,3,2,3,6,4,2,1},
			{2,3,2,1,3,12,12,1,4,2,4,1},
			{3,6,3,1,1,12,12,4,2,4,2,6},
			{2,4,3,3,1,1,4,1,2,3,2,1},
			{3,3,1,3,2,3,1,1,3,6,2,1},
			{3,3,3,6,4,6,4,1,4,4,2,1},
			{1,1,4,4,1,2,1,4,2,4,4,1},
			{10,3,3,3,3,3,3,1,3,3,3,11}};

	public FakeDatabase() {
		boardDataList = new ArrayList<RocketPadsBoardData>();

		RocketPadsBoardData data1 = RocketPadsCreateBoardDataFromArray.createFromArray(board1, BoardList.Classic1);
		RocketPadsBoardData data2 = RocketPadsCreateBoardDataFromArray.createFromArray(board2, BoardList.Classic2);
		RocketPadsBoardData data3 = RocketPadsCreateBoardDataFromArray.createFromArray(board3, BoardList.Classic3);
		
		boardDataList.add(data1);
		boardDataList.add(data2);
		boardDataList.add(data3);
	}
	
	@Override
	public RocketPadsBoardData getBoardData(BoardList board) {
		for (RocketPadsBoardData boardData : boardDataList) {
			if (boardData.getBoard() == board) {
				return boardData;
			}
		}
		return null;
	}

}
