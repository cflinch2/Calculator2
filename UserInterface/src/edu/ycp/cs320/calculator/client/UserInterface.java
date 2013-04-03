package edu.ycp.cs320.calculator.client;

import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.dom.client.Style.Unit;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.LayoutPanel;

import com.google.gwt.user.client.ui.RootLayoutPanel;

import edu.ycp.cs320.calculator.shared.RocketPadsGame;

public class UserInterface implements EntryPoint {

	public void onModuleLoad() {

		GameLobby gameSelection = new GameLobby();
		
		GameLobby.update();
	
		RootLayoutPanel.get().add(gameSelection);
		RootLayoutPanel.get().setWidgetLeftRight(gameSelection, 0.0, Unit.PX, 0.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(gameSelection, 0.0, Unit.PX, 0.0, Unit.PX);
	}
}
