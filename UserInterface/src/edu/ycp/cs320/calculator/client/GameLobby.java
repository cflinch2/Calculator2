package edu.ycp.cs320.calculator.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import edu.ycp.cs320.calculator.shared.GameList;
import edu.ycp.cs320.calculator.shared.RocketPadsGame;

public class GameLobby extends Composite {
	private Button selector;
	private InlineLabel gameSelection;
	private InlineLabel user;
	private TextBox uName;
	private InlineLabel gamePanel;
	private Image image;
	private static ListBox gameListBox;
	private LayoutPanel layoutPanel;
		
	
	public GameLobby() {
		// Create base panel.
		LayoutPanel basePanel = new LayoutPanel();
		initWidget(basePanel);
		basePanel.setSize("1100px", "900px");
		
		// Create image object for background picture.
		image = new Image();
		image.setUrl("lobby_screen2.png");
		basePanel.add(image);
		image.setSize("1100px", "900px");
		basePanel.setWidgetLeftRight(image, 0.0, Unit.PX, 0.0, Unit.PX);
		basePanel.setWidgetTopBottom(image, 0.0, Unit.PX, 0.0, Unit.PX);
		
		// Create user interface panel.
		final LayoutPanel UI = new LayoutPanel();
		basePanel.add(UI);
		basePanel.setWidgetLeftRight(UI, 0.0, Unit.PX, 0.0, Unit.PX);
		basePanel.setWidgetTopBottom(UI, 0.0, Unit.PX, 0.0, Unit.PX);
		
		// Gam list drop-down menu.
		gameListBox = new ListBox();
		UI.add(gameListBox);
		UI.setWidgetLeftWidth(gameListBox, 69.0, Unit.PX, 100.0, Unit.PX);
		UI.setWidgetTopHeight(gameListBox, 51.0, Unit.PX, 25.0, Unit.PX);
		
		// User label.
		user = new InlineLabel("User:");
		UI.add(user);
		UI.setWidgetLeftWidth(user, 28.0, Unit.PX, 55.0, Unit.PX);
		UI.setWidgetTopHeight(user, 25.0, Unit.PX, 25.0, Unit.PX);
		
		// Text box for username input.
		uName = new TextBox();
		UI.add(uName);
		UI.setWidgetLeftWidth(uName, 69.0, Unit.PX, 100.0, Unit.PX);
		UI.setWidgetTopHeight(uName, 21.0, Unit.PX, 25.0, Unit.PX);
		
		// Play button
		selector = new Button();
		UI.add(selector);
		selector.setText("Play!");
		selector.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) { 
				// gamePanel.setText(getUName() + " is Playing " + getChange());	
				
				// Create RocketPadsGame instance and add it to the view model.
				RocketPadsGame game = new RocketPadsGame(1);
				RocketPadsView view = new RocketPadsView();
				view.setModel(game);
				layoutPanel.add(view);
				layoutPanel.setWidgetLeftRight(view, 0.0, Unit.PX, 0.0, Unit.PX);
				layoutPanel.setWidgetTopBottom(view, 0.0, Unit.PX, 0.0, Unit.PX);
				view.activate();
			}
		});
		// Adjust dimensions.
		UI.setWidgetLeftWidth(selector, 69.0, Unit.PX, 50.0, Unit.PX);
		UI.setWidgetTopHeight(selector, 515.0, Unit.PX, 25.0, Unit.PX);
		
		gamePanel = new InlineLabel();
		UI.add(gamePanel);
		UI.setWidgetLeftWidth(gamePanel, 410.0, Unit.PX, 250.0, Unit.PX);
		UI.setWidgetTopHeight(gamePanel, 20.0, Unit.PX, 25.0, Unit.PX);	
		
		// Game label
		gameSelection = new InlineLabel("Game:");
		UI.add(gameSelection);
		UI.setWidgetLeftWidth(gameSelection, 25.0, Unit.PX, 50.0, Unit.PX);
		UI.setWidgetTopHeight(gameSelection, 55.0, Unit.PX, 25.0, Unit.PX);
		
		// Game screen panel
		layoutPanel = new LayoutPanel();
		UI.add(layoutPanel);
		UI.setWidgetLeftWidth(layoutPanel, 200.0, Unit.PX, 900.0, Unit.PX);
		UI.setWidgetTopHeight(layoutPanel, 0.0, Unit.PX, 900.0, Unit.PX);
	}
	
	public String getChange() {
		int sel = gameListBox.getSelectedIndex();
		String GameChoice = gameListBox.getValue(sel);
		return GameChoice;
	}
	
	public String getUName() {
		String name = uName.getText();
		return name;
	}

	public static void update() {
		if (gameListBox.getItemCount() == 0) {
			GameList[] games = GameList.values();
			for (GameList g : games) {
				gameListBox.addItem(g.toString());
			}
		}
	}
}
