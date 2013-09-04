package edu.ycp.cs320.calculator.client;

import com.google.gwt.core.shared.GWT;

public class RPC {
	public static final GameDataServiceAsync gameService =
			GWT.create(GameDataService.class);
}
