package edu.ycp.cs320.calculator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;


public class UserInterface implements EntryPoint {

	public void onModuleLoad() {

		LayoutPanel panel = new LayoutPanel();
		
		GameLobby gameSelection = new GameLobby();
		
		panel.add(gameSelection);
		gameSelection.setSize("1024", "1024");
		GameLobby.update();
		
		RootLayoutPanel.get().add(panel);
		RootLayoutPanel.get().setWidgetLeftRight(panel, 0.0, Unit.PX, 0.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(panel, 0.0, Unit.PX, 0.0, Unit.PX);
	}
}
