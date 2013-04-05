package edu.ycp.cs320.calculator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RootLayoutPanel;


public class UserInterface implements EntryPoint {

	
	// Entry point method.
	public void onModuleLoad() {

		GameLobby lobby = new GameLobby();
		
		GameLobby.update();
	
		RootLayoutPanel.get().add(lobby);
		RootLayoutPanel.get().setWidgetLeftRight(lobby, 0.0, Unit.PX, 0.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(lobby, 0.0, Unit.PX, 0.0, Unit.PX);
	}
}
