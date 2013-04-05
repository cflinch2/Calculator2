package edu.ycp.cs320.calculator.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import edu.ycp.cs320.calculator.shared.GameList;
import edu.ycp.cs320.calculator.shared.RocketPadsGame;

public class GameLobby extends Composite {
	private Button selector;
	private InlineLabel lobby;
	private InlineLabel user;
	private TextBox uName;
	private InlineLabel gamePanel;
	private static ListBox gameListBox;
	private LayoutPanel layoutPanel;
	private Image background;
	private Image slidepad_east, slidepad_west, slidepad_north, slidepad_south;
	private Image startzone_red, startzone_blue, startzone_green, startzone_yellow;
	private Image winzone_tl, winzone_tr, winzone_bl, winzone_br;
	private Image stoppad;
	private String slidepad_east_url, slidepad_west_url, slidepad_north_url, slidepad_south_url;
	private String startzone_red_url, startzone_blue_url, startzone_green_url, startzone_yellow_url;
	private String winzone_tl_url, winzone_tr_url, winzone_bl_url, winzone_br_url;
	private String stoppad_url;
	
	public GameLobby() {
		// Create base panel.
		LayoutPanel basePanel = new LayoutPanel();
		initWidget(basePanel);
		basePanel.setSize("1100px", "900px");
		
		// Load images.
		String background_url = GWT.getModuleBaseForStaticFiles() + "lobby_screen2.png";
		String startzone_red_url = GWT.getModuleBaseForStaticFiles() + "startzone_red.png";
		// more images...
		
		// Create Image objects.
		background = new Image(background_url);
		startzone_red = new Image(startzone_red_url);
		// more image objects...
		
		// Add background image to base panel.
		basePanel.add(background);
		background.setSize("1100px", "900px");
		basePanel.setWidgetLeftRight(background, 0.0, Unit.PX, 0.0, Unit.PX);
		basePanel.setWidgetTopBottom(background, 0.0, Unit.PX, 0.0, Unit.PX);
		
		// Create user interface panel.
		final LayoutPanel UI = new LayoutPanel();
		basePanel.add(UI);
		basePanel.setWidgetLeftRight(UI, 0.0, Unit.PX, 0.0, Unit.PX);
		basePanel.setWidgetTopBottom(UI, 0.0, Unit.PX, 0.0, Unit.PX);
		
		// Game list drop-down menu.
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
				// Create RocketPadsGame instance and add it to the view model.
				RocketPadsGame game = new RocketPadsGame(1);
				RocketPadsView view = new RocketPadsView();
				view.setModel(game);
				
				// Create image panel.
				FlowPanel image_panel = new FlowPanel();
				
				image_panel.add(startzone_red);
				
				image_panel.setSize("0px", "0px");
				
				layoutPanel.add(image_panel);
				
				layoutPanel.add(view);
				
				layoutPanel.setWidgetLeftRight(view, 0.0, Unit.PX, 0.0, Unit.PX);
				layoutPanel.setWidgetTopBottom(view, 0.0, Unit.PX, 0.0, Unit.PX);
				
				// Give the view object appropriate references for painting.
				view.set_startzone_red(startzone_red);
				
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
		lobby = new InlineLabel("Game:");
		UI.add(lobby);
		UI.setWidgetLeftWidth(lobby, 25.0, Unit.PX, 50.0, Unit.PX);
		UI.setWidgetTopHeight(lobby, 55.0, Unit.PX, 25.0, Unit.PX);
		
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
