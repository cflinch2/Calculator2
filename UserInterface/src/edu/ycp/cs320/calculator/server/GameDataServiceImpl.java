package edu.ycp.cs320.calculator.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.calculator.client.GameDataService;
import edu.ycp.cs320.calculator.shared.BoardList;
import edu.ycp.cs320.calculator.shared.RocketPadsBoardData;

public class GameDataServiceImpl extends RemoteServiceServlet implements GameDataService {

	@Override
	public RocketPadsBoardData getBoardData(BoardList board) {
		return DB.instance().getBoardData(board);
	}

}
