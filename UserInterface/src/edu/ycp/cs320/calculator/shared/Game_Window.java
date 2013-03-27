package edu.ycp.cs320.calculator.shared;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import edu.ycp.cs320.calculator.client.RocketPadsView;

public class Game_Window extends PopupPanel {
	
	public Game_Window() {
		RocketPadsGame game = new RocketPadsGame(1);
		RocketPadsView view = new RocketPadsView();
		view.setModel(game);
		
		FlowPanel imagePanel = new FlowPanel();
		// imagePanel.add(player_sprite);
		imagePanel.setSize(RocketPadsGame.WIDTH + "px", RocketPadsGame.HEIGHT + "px");
		
		// Add the view.
		RootLayoutPanel.get().add(view);
		
		view.activate();
	}
}


