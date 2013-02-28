package edu.ycp.cs320.calculator.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Button;

import edu.ycp.cs320.calculator.shared.GameList;
import edu.ycp.cs320.calculator.shared.RocketPadsPanel;


public class Game_Selection extends Composite {
	
	private RocketPadsPanel floor;
	private Button selector;
	private InlineLabel gameSelection;
	private static ListBox gameListBox;
	
	
	public Game_Selection(){
		
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		
		gameSelection = new InlineLabel("Game:");
		layoutPanel.add(gameSelection);
		layoutPanel.setWidgetLeftWidth(gameSelection, 10.0, Unit.PX, 50.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(gameSelection, 10.0, Unit.PX, 20.0, Unit.PX);
		
		gameListBox = new ListBox();
		layoutPanel.add(gameListBox);
		layoutPanel.setWidgetLeftWidth(gameListBox, 75.0, Unit.PX, 150.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(gameListBox, 10.0, Unit.PX, 20.0, Unit.PX);
		
		selector = new Button();
		selector.setText("Play!");
		selector.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				
			}
		});
		layoutPanel.add(selector);
		layoutPanel.setWidgetLeftWidth(selector, 200.0, Unit.PX, 300.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(selector, 10.0, Unit.PX, 30.0, Unit.PX);
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
