package edu.ycp.cs320.calculator.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;

import edu.ycp.cs320.calculator.shared.GameList;
import edu.ycp.cs320.calculator.shared.RocketPadsPanel;




public class Game_Selection extends Composite {
	
	private RocketPadsPanel floor;
	private Button selector;
	private InlineLabel gameSelection;
	private InlineLabel gamePanel;
	private static ListBox gameListBox;
	
	
	public Game_Selection(){
		
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("1000px", "750px");
		
			
		gameSelection = new InlineLabel("Game:");
		layoutPanel.add(gameSelection);
		layoutPanel.setWidgetLeftWidth(gameSelection, 15.0, Unit.PX, 100.0, Unit.PX );
		layoutPanel.setWidgetTopHeight(gameSelection, 15.0, Unit.PX, 25.0, Unit.PX);
		
		gameListBox = new ListBox();
		layoutPanel.add(gameListBox);
		layoutPanel.setWidgetLeftWidth(gameListBox, 125.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(gameListBox, 15.0, Unit.PX, 25.0, Unit.PX);
		
		gamePanel = new InlineLabel();
		layoutPanel.setWidgetLeftWidth(gamePanel, 275.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(gamePanel, 15.0, Unit.PX, 25.0, Unit.PX);
		
		selector = new Button();
		layoutPanel.add(selector);
		selector.setText("Play!");
		selector.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				gamePanel.setText(gameListBox.getItemText(0));
				
				
				
			}
		});
		layoutPanel.setWidgetLeftWidth(selector, 250.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(selector, 15.0, Unit.PX, 25.0, Unit.PX);
		
		Image image = new Image();
		image.setUrl("WEB-INF/classes/edu/ycp/cs320/calculator/client/old-classic-board-games.jpg");
		layoutPanel.add(image);
		layoutPanel.setWidgetLeftWidth(image, 125.0, Unit.PX, 500.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(image, 50.0, Unit.PX, 500.0, Unit.PX);
		
		
		
	}
	

	public void setFloor(RocketPadsPanel floor){
		this.floor = floor;
	}
	
	public static void update(){
		if (gameListBox.getItemCount() == 0) {
			GameList[] games = GameList.values();
			for (GameList g : games) {
				gameListBox.addItem(g.toString());
			}
		}
	}
}
