package edu.ycp.cs320.calculator.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

import edu.ycp.cs320.calculator.shared.AvatarList;
import edu.ycp.cs320.calculator.shared.BoardList;
import edu.ycp.cs320.calculator.shared.RocketPadsBoardData;
import edu.ycp.cs320.calculator.shared.RocketPadsGame;
import edu.ycp.cs320.calculator.shared.User;

public class GameLobby extends Composite {
	private Button selector;
	private InlineLabel user, pass, av, board, gamePanel;
	private TextBox uName, pWord;
	private ListBox gameListBox, avatar;
	private LayoutPanel layoutPanel;
	private Image background;
	private String background_url = "lobby_screen2.png";

	public GameLobby() {
		// Create base panel.
		LayoutPanel basePanel = new LayoutPanel();
		initWidget(basePanel);
		basePanel.setSize("1100px", "900px");
		GWT.log("  Base panel created.");
		
		// Add background image to base panel.
		GWT.log("Loading background image...");
		String url = GWT.getModuleBaseForStaticFiles() + background_url;
		background = new Image(url);
		basePanel.add(background);
		background.setSize("1100px", "900px");
		basePanel.setWidgetLeftRight(background, 0.0, Unit.PX, 0.0, Unit.PX);
		basePanel.setWidgetTopBottom(background, 0.0, Unit.PX, 0.0, Unit.PX);
		GWT.log("  Background image loaded and added to base panel.");
		
		// Create user interface panel.
		final LayoutPanel UI = new LayoutPanel();
		basePanel.add(UI);
		basePanel.setWidgetLeftRight(UI, 0.0, Unit.PX, 0.0, Unit.PX);
		basePanel.setWidgetTopBottom(UI, 0.0, Unit.PX, 0.0, Unit.PX);
		GWT.log("  Interface panel created.");
		
		// Username label.
		user = new InlineLabel("User:");
		UI.add(user);
		UI.setWidgetLeftWidth(user, 28.0, Unit.PX, 55.0, Unit.PX);
		UI.setWidgetTopHeight(user, 24.0, Unit.PX, 25.0, Unit.PX);
		
		// Text box for username input.
		uName = new TextBox();
		UI.add(uName);
		UI.setWidgetLeftWidth(uName, 69.0, Unit.PX, 110.0, Unit.PX);
		UI.setWidgetTopHeight(uName, 20.0, Unit.PX, 25.0, Unit.PX);
		
		// Password label.
		pass = new InlineLabel("Pass:");
		UI.add(pass);
		UI.setWidgetLeftWidth(pass, 28.0, Unit.PX, 55.0, Unit.PX);
		UI.setWidgetTopHeight(pass, 64.0, Unit.PX, 25.0, Unit.PX);
		
		// Text box for password input.
		pWord = new TextBox();
		UI.add(pWord);
		UI.setWidgetLeftWidth(pWord, 69.0, Unit.PX, 110.0, Unit.PX);
		UI.setWidgetTopHeight(pWord, 60.0, Unit.PX, 25.0, Unit.PX);
		
		// Board label.
		board = new InlineLabel("Board:");
		UI.add(board);
		UI.setWidgetLeftWidth(board, 27.0, Unit.PX, 50.0, Unit.PX);
		UI.setWidgetTopHeight(board, 103.0, Unit.PX, 25.0, Unit.PX);
		
		// Game list drop-down menu.
		gameListBox = new ListBox();
		UI.add(gameListBox);
		UI.setWidgetLeftWidth(gameListBox, 69.0, Unit.PX, 110.0, Unit.PX);
		UI.setWidgetTopHeight(gameListBox, 100.0, Unit.PX, 25.0, Unit.PX);
		
		// Avatar label.
		av = new InlineLabel("Avatar:");
		UI.add(av);
		UI.setWidgetLeftWidth(av, 25.0, Unit.PX, 50.0, Unit.PX);
		UI.setWidgetTopHeight(av, 143.0, Unit.PX, 25.0, Unit.PX);
		
		// Text box for avatar selection.
		avatar = new ListBox();
		UI.add(avatar);
		UI.setWidgetLeftWidth(avatar, 69.0, Unit.PX, 110.0, Unit.PX);
		UI.setWidgetTopHeight(avatar, 140.0, Unit.PX, 25.0, Unit.PX);
		
		// Play button
		selector = new Button();
		UI.add(selector);
		selector.setText("Play!");
		selector.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) { 	
				// Create RocketPadsGame instance and add it to the view model.
				GWT.log("  Entered on-click event handler for 'Play!'");
				
				// Chosen board.
				String chosen_board = gameListBox.getItemText(gameListBox.getSelectedIndex());
				BoardList board = BoardList.valueOf(chosen_board);
				
				// Chosen avatar.
				String chosen_avatar = avatar.getItemText(avatar.getSelectedIndex());
				AvatarList a = AvatarList.valueOf(chosen_avatar);
				
				RPC.gameService.createUser(getUName(), getPWord(), a, new AsyncCallback<User>() {
					@Override
					public void onSuccess(User user) {
						GWT.log("   Successfully created user!");
					}
					
					@Override
					public void onFailure(Throwable caught) {
						GWT.log("   RPC call to create user failed!", caught);
					}
				});
				
				RPC.gameService.getBoardData(board, new AsyncCallback<RocketPadsBoardData>() {
					@Override
					public void onSuccess(RocketPadsBoardData result) {
						GWT.log("   Successfully loaded board data!");
						RocketPadsGame game = new RocketPadsGame(result);
						GWT.log("   Game instance created.");
						RocketPadsView view = new RocketPadsView();
						view.setModel(game);
						GWT.log("   View created and set to game model.");
						
						layoutPanel.add(view);
						layoutPanel.setWidgetLeftRight(view, 0.0, Unit.PX, 0.0, Unit.PX);
						layoutPanel.setWidgetTopBottom(view, 0.0, Unit.PX, 0.0, Unit.PX);

						view.activate();
						GWT.log("   View activated.");
					}
					
					@Override
					public void onFailure(Throwable caught) {
						GWT.log("   RPC call to get board data failed!", caught);
					}
				});
			}
		});
		
		// Adjust dimensions.
		UI.setWidgetLeftWidth(selector, 35.0, Unit.PX, 140.0, Unit.PX);
		UI.setWidgetTopHeight(selector, 815.0, Unit.PX, 30.0, Unit.PX);
		
		gamePanel = new InlineLabel();
		UI.add(gamePanel);
		UI.setWidgetLeftWidth(gamePanel, 410.0, Unit.PX, 250.0, Unit.PX);
		UI.setWidgetTopHeight(gamePanel, 20.0, Unit.PX, 25.0, Unit.PX);	
		
		// Game screen panel
		layoutPanel = new LayoutPanel();
		UI.add(layoutPanel);
		UI.setWidgetLeftWidth(layoutPanel, 200.0, Unit.PX, 900.0, Unit.PX);
		UI.setWidgetTopHeight(layoutPanel, 0.0, Unit.PX, 900.0, Unit.PX);
		GWT.log("- Game layout panel created.");
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
	
	public String getPWord() {
		String pass = pWord.getText();
		return pass;
	}

	public void update() {
		// Populate board list.
		if(gameListBox.getItemCount() == 0) {
			BoardList[] games = BoardList.values();
			for (BoardList g : games) {
				gameListBox.addItem(g.toString());
			}
		}
		// Populate avatar list.
		if (avatar.getItemCount() == 0) {
			AvatarList[] avatars = AvatarList.values();
			for (AvatarList g : avatars) {
				avatar.addItem(g.toString());
			}
		}
	}

}