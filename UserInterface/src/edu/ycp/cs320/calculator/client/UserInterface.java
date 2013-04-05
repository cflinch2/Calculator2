package edu.ycp.cs320.calculator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.google.gwt.dom.client.Style.Unit;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.LayoutPanel;

import com.google.gwt.user.client.ui.RootLayoutPanel;

import edu.ycp.cs320.calculator.shared.RocketPadsGame;

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
