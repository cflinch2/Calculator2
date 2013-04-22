package edu.ycp.cs320.calculator.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.calculator.shared.BoardList;
import edu.ycp.cs320.calculator.shared.RocketPadsBoardData;

@RemoteServiceRelativePath("gameData")
public interface GameDataService extends RemoteService {
	public RocketPadsBoardData getBoardData(BoardList board); // sometime make this a string
}
