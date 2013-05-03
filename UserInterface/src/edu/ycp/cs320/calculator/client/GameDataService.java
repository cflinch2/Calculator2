package edu.ycp.cs320.calculator.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import edu.ycp.cs320.calculator.shared.AvatarList;
import edu.ycp.cs320.calculator.shared.BoardList;
import edu.ycp.cs320.calculator.shared.RocketPadsBoardData;
import edu.ycp.cs320.calculator.shared.User;

@RemoteServiceRelativePath("gameData")
public interface GameDataService extends RemoteService {
	public RocketPadsBoardData getBoardData(BoardList board);
	public User createUser(int id, String username, String password, AvatarList avatar);
}
