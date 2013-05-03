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
	private AvatarList avatar;
	private String username, password;

	public static int[][] tutorial = {{6,3,3,3,3,3,3,3,3,3,3,2},
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

	public FakeDatabase() {
		boardDataList = new ArrayList<RocketPadsBoardData>();

		RocketPadsBoardData data1 = RocketPadsCreateBoardDataFromArray.createFromArray(tutorial, BoardList.Tutorial);
		
		boardDataList.add(data1);
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
	public User createUser(int id, String username, String password,
			AvatarList avatar) {
		return null;
	}
}
