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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;


public class Game_Selection extends Composite {
	
	private RocketPadsPanel floor;
	private Button selector;
	private InlineLabel gameSelection;
	private static ListBox gameListBox;
	
	
	public Game_Selection(){
		
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("1000px", "750px");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		layoutPanel.add(verticalPanel);
		verticalPanel.setSize("1000", "100");
		layoutPanel.setWidgetLeftWidth(verticalPanel, 0.0, Unit.PX, 1000.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(verticalPanel, 0.0, Unit.PX, 100.0, Unit.PX);
		
		gameSelection = new InlineLabel("Game:");
		verticalPanel.add(gameSelection);
		
		gameListBox = new ListBox();
		verticalPanel.add(gameListBox);
		
		selector = new Button();
		verticalPanel.add(selector);
		selector.setText("Play!");
		selector.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				
			}
		});
		selector.setSize("120", "36");
		
		Image image = new Image("WEB-INF/classes/edu/ycp/cs320/calculator/client/old-classic-board-games.jpg");
		image.setStyleName("gwt-DialogBox");
		layoutPanel.add(image);
		image.setSize("500", "500");
		layoutPanel.setWidgetLeftWidth(image, 147.0, Unit.PX, 100.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(image, 108.0, Unit.PX, 100.0, Unit.PX);
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
