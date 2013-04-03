package edu.ycp.cs320.calculator.shared;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import edu.ycp.cs320.calculator.client.RocketPadsView;

public class RocketPadsWindow {
	
	public RocketPadsWindow() {
		RocketPadsGame game = new RocketPadsGame(1);
		RocketPadsView view = new RocketPadsView();
		view.setModel(game);
		
		FlowPanel imagePanel = new FlowPanel();
		imagePanel.setSize(RocketPadsGame.WIDTH + "px", RocketPadsGame.HEIGHT + "px");
		
		// Add the view.
		RootLayoutPanel.get().add(view);
		
		view.activate();
	}
}


