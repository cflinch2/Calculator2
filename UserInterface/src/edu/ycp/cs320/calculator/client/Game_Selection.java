package edu.ycp.cs320.calculator.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;

import edu.ycp.cs320.calculator.shared.GameList;

public class Game_Selection extends Composite {
	
	//private RocketPadsPanel floor;
	//private Game_play gPage;
	private Button selector;
	private InlineLabel gameSelection;
	private InlineLabel gamePanel;
	private InlineLabel user;
	private TextBox uName;
	private Image rocketpads;
	private Image image;
	private static ListBox gameListBox;
	
	
	public Game_Selection(){
		
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("1000px", "750px");
		//layoutPanel.setVisible(false);
			
		gameSelection = new InlineLabel("Game:");
		layoutPanel.add(gameSelection);
		layoutPanel.setWidgetLeftWidth(gameSelection, 15.0, Unit.PX, 50.0, Unit.PX );
		layoutPanel.setWidgetTopHeight(gameSelection, 15.0, Unit.PX, 25.0, Unit.PX);
		
		gameListBox = new ListBox();
		layoutPanel.add(gameListBox);
		layoutPanel.setWidgetLeftWidth(gameListBox, 75.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(gameListBox, 15.0, Unit.PX, 25.0, Unit.PX);
		
		user = new InlineLabel("User:");
		layoutPanel.add(user);
		layoutPanel.setWidgetLeftWidth(user, 185.0, Unit.PX, 50.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(user, 15.0, Unit.PX, 25.0, Unit.PX);
		
		uName = new TextBox();
		layoutPanel.add(uName);
		layoutPanel.setWidgetLeftWidth(uName, 245.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(uName, 15.0, Unit.PX, 25.0, Unit.PX);
		
				selector = new Button();
		layoutPanel.add(selector);
		selector.setText("Play!");
		selector.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				
				String selGame = getChange();
				
				if(selGame == "RocketPads"){
					rocketpads.setVisible(true);
														
				}
				
				gamePanel.setText(getUName() + " is Playing " + getChange());
								
			}
		});
		layoutPanel.setWidgetLeftWidth(selector, 355.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(selector, 15.0, Unit.PX, 25.0, Unit.PX);
		
		gamePanel = new InlineLabel();
		layoutPanel.add(gamePanel);
		layoutPanel.setWidgetLeftWidth(gamePanel, 410.0, Unit.PX, 50.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(gamePanel, 15.0, Unit.PX, 25.0, Unit.PX);
		
		
		
		image = new Image();
		image.setUrl("userinterface/lobby_screen.png");
		layoutPanel.add(image);
		layoutPanel.setWidgetLeftWidth(image, 125.0, Unit.PX, 500.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(image, 50.0, Unit.PX, 500.0, Unit.PX);
				
	}
	
	public String getChange(){
		int sel = gameListBox.getSelectedIndex();
		String GameChoice = gameListBox.getValue(sel);
		return GameChoice;
	}
	
	public String getUName(){
		String name = uName.getText();
		return name;
	}

	/*public void setFloor(RocketPadsPanel floor){
		this.floor = floor;
	}*/
	
	public static void update(){
		if (gameListBox.getItemCount() == 0) {
			GameList[] games = GameList.values();
			for (GameList g : games) {
				gameListBox.addItem(g.toString());
			}
		}
	}
}
