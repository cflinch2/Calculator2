package edu.ycp.cs320.calculator.client;

import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.dom.client.Style.Unit;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.LayoutPanel;

import com.google.gwt.user.client.ui.RootLayoutPanel;

import edu.ycp.cs320.calculator.shared.RocketPadsGame;

public class UserInterface implements EntryPoint {

	public void onModuleLoad() {
		
		RocketPadsGame game = new RocketPadsGame(1);
		RocketPadsView view = new RocketPadsView();
		view.setModel(game);
		
		FlowPanel imagePanel = new FlowPanel();
		// imagePanel.add(player_sprite);
		imagePanel.setSize(RocketPadsGame.WIDTH + "px", RocketPadsGame.HEIGHT + "px");
		
		// Add the view.
		RootLayoutPanel.get().add(view);
		
		view.activate();
		
		/*
		LayoutPanel panel = new LayoutPanel();
		
		Game_Selection gameSelection = new Game_Selection();
		
		panel.add(gameSelection);
		gameSelection.setSize("1024", "1024");
		Game_Selection.update();
		
		RootLayoutPanel.get().add(panel);
		RootLayoutPanel.get().setWidgetLeftRight(panel, 0.0, Unit.PX, 0.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(panel, 0.0, Unit.PX, 0.0, Unit.PX);
		*/
	}

}
