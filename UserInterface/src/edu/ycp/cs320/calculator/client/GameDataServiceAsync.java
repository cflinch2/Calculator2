package edu.ycp.cs320.calculator.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.calculator.shared.AvatarList;
import edu.ycp.cs320.calculator.shared.BoardList;
import edu.ycp.cs320.calculator.shared.RocketPadsBoardData;
import edu.ycp.cs320.calculator.shared.User;

public interface GameDataServiceAsync {

	void getBoardData(BoardList board,
			AsyncCallback<RocketPadsBoardData> callback);
	
	void createUser(String username, String password, AvatarList avatar, AsyncCallback<User> callback);
}
