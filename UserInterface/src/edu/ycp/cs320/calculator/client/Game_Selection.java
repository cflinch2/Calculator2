package edu.ycp.cs320.calculator.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import edu.ycp.cs320.calculator.shared.GameList;

public class Game_Selection extends Composite {
	private Button selector;
	private InlineLabel gameSelection;
	private InlineLabel user;
	private TextBox uName;
	private InlineLabel gamePanel;
	private Image image;
	private static ListBox gameListBox;
		
	
	public Game_Selection(){
		
		LayoutPanel basePanel = new LayoutPanel();
		initWidget(basePanel);
		basePanel.setSize("1000px", "750px");
				
		image = new Image();
		image.setUrl("userinterface/lobby_screen.png");
		basePanel.add(image);
		image.setSize("1000", "750");
		basePanel.setWidgetLeftWidth(image, 190.0, Unit.PX, 1000.0, Unit.PX);
		basePanel.setWidgetTopHeight(image, 0.0, Unit.PX, 795.0, Unit.PX);
		
		final LayoutPanel UI = new LayoutPanel();
		basePanel.add(UI);
		basePanel.setWidgetLeftWidth(UI, 200.0, Unit.PX, 1000.0, Unit.PX);
		basePanel.setWidgetTopHeight(UI, 0.0, Unit.PX, 750.0, Unit.PX);
		
		gameSelection = new InlineLabel("Game:");
		UI.add(gameSelection);
		UI.setWidgetLeftWidth(gameSelection, 15.0, Unit.PX, 50.0, Unit.PX);
		UI.setWidgetTopHeight(gameSelection, 20.0, Unit.PX, 25.0, Unit.PX);
		
		gameListBox = new ListBox();
		UI.add(gameListBox);
		UI.setWidgetLeftWidth(gameListBox, 75.0, Unit.PX, 100.0, Unit.PX);
		UI.setWidgetTopHeight(gameListBox, 15.0, Unit.PX, 25.0, Unit.PX);
		
		user = new InlineLabel("User:");
		UI.add(user);
		UI.setWidgetLeftWidth(user, 185.0, Unit.PX, 50.0, Unit.PX);
		UI.setWidgetTopHeight(user, 20.0, Unit.PX, 25.0, Unit.PX);
		
		uName = new TextBox();
		UI.add(uName);
		UI.setWidgetLeftWidth(uName, 245.0, Unit.PX, 100.0, Unit.PX);
		UI.setWidgetTopHeight(uName, 15.0, Unit.PX, 25.0, Unit.PX);
		
				selector = new Button();
				UI.add(selector);
				selector.setText("Play!");
				selector.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						String selGame = getChange();
						
						final RocketPadsView popUp = new RocketPadsView();
						popUp.setSize("900px", "900px");
						
						gamePanel.setText(getUName() + " is Playing " + getChange());				
					}
				});
				
				UI.setWidgetLeftWidth(selector, 355.0, Unit.PX, 50.0, Unit.PX);
				UI.setWidgetTopHeight(selector, 15.0, Unit.PX, 25.0, Unit.PX);
				
				gamePanel = new InlineLabel();
				UI.add(gamePanel);
				UI.setWidgetLeftWidth(gamePanel, 410.0, Unit.PX, 250.0, Unit.PX);
				UI.setWidgetTopHeight(gamePanel, 20.0, Unit.PX, 25.0, Unit.PX);	
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
