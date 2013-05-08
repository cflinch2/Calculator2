package edu.ycp.cs320.calculator.server;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.calculator.shared.AvatarList;
import edu.ycp.cs320.calculator.shared.BoardList;
import edu.ycp.cs320.calculator.shared.IDatabase;
import edu.ycp.cs320.calculator.shared.RocketPadsBoardData;
import edu.ycp.cs320.calculator.shared.RocketPadsCreateBoardDataFromArray;
import edu.ycp.cs320.calculator.shared.User;

public class FakeDatabase implements IDatabase {
	private List<RocketPadsBoardData> boardDataList;

	public static int[][] tutorial = {
			{6,3,3,3,3,3,3,3,3,3,3,2},
			{2,5,5,5,5,5,5,5,5,5,5,2},
			{2,5,5,5,5,5,5,5,5,5,5,2},
			{2,5,5,5,5,5,5,5,5,5,5,2},
			{2,5,5,5,5,5,5,5,5,5,5,2},
			{2,5,5,5,5,5,5,5,5,5,5,2},
			{2,5,5,5,5,5,5,5,5,5,5,2},
			{2,5,5,5,5,5,5,5,5,5,5,2},
			{2,5,5,5,5,5,5,5,5,5,5,2},
			{2,5,5,5,5,5,5,5,5,5,5,2},
			{2,5,5,5,5,5,5,5,5,5,5,2},
			{3,3,3,3,3,3,3,3,3,3,3,7}};
	
	public static int[][] level_2 = {
			{6,3,3,3,3,2,2,4,4,4,4,4},
			{2,2,4,4,1,2,2,1,5,3,2,1},
		    {2,2,2,4,1,2,2,1,1,3,2,1},
			{3,3,5,1,1,2,2,1,1,4,2,1},
			{2,1,2,1,1,5,5,1,1,1,5,1},
			{2,1,2,1,4,5,5,1,3,1,2,2},
			{2,1,2,1,4,4,3,1,1,2,2,2},
			{2,5,3,2,3,3,2,1,1,2,2,2},
			{2,1,4,4,1,2,5,3,1,2,2,2},
			{2,3,3,2,1,2,1,2,4,4,4,2},
			{2,1,2,4,1,2,1,3,3,3,3,2},
			{3,1,3,3,1,3,1,3,3,3,3,7}};
	
	public static int[][] level_3 = {
			{6,3,2,3,3,3,3,5,3,3,3,2},
			{3,1,5,1,4,4,4,4,2,4,4,2},
		    {3,2,2,1,2,5,3,1,2,2,1,2},
			{2,4,2,1,2,1,2,4,5,2,1,2},
			{2,1,2,1,2,1,4,4,2,3,5,2},
			{3,2,5,4,3,7,2,3,2,1,2,2},
			{2,4,2,1,4,3,3,2,5,1,2,2},
			{2,3,3,2,1,5,4,2,1,4,4,2},
			{3,2,1,4,4,1,1,3,1,2,4,4},
			{2,5,1,1,3,1,1,4,4,4,2,2},
			{2,3,3,3,1,3,2,3,5,4,3,2},
			{3,3,3,3,5,1,3,1,3,1,1,4}};
	

	public FakeDatabase() {
		boardDataList = new ArrayList<RocketPadsBoardData>();

		RocketPadsBoardData data1 = RocketPadsCreateBoardDataFromArray.createFromArray(tutorial, BoardList.Tutorial);
		RocketPadsBoardData data2 = RocketPadsCreateBoardDataFromArray.createFromArray(level_2, BoardList.Level_2);
		RocketPadsBoardData data3 = RocketPadsCreateBoardDataFromArray.createFromArray(level_3, BoardList.Level_3);
		
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

	@Override
	public User createUser(String username, String password, AvatarList avatar) {
		// TODO Auto-generated method stub
		return null;
	}
}
