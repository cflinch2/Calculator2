package edu.ycp.cs320.calculator.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.calculator.shared.BoardList;
import edu.ycp.cs320.calculator.shared.RocketPadsBoardData;

public interface GameDataServiceAsync {

	void getBoardData(BoardList board,
			AsyncCallback<RocketPadsBoardData> callback);

}
