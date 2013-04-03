package edu.ycp.cs320.calculator.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.PopupPanel;

import edu.ycp.cs320.calculator.shared.RPCanvas;


public class GameView extends PopupPanel {

	String choice;
	Label pos = new Label();
	int mouseX, mouseY;
	
	public GameView(String game){
		super(true);
		LayoutPanel Test = new LayoutPanel();
		
		Label playGame = new Label(game);
		playGame.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		Test.add(playGame);
		
		choice = game;
		
		pos.setText(mouseX + ", " + mouseY);		
		Test.add(pos);
		Test.setWidgetRightWidth(pos, 0.0, Unit.PX, 25.0, Unit.PX);
		Test.setWidgetTopHeight(pos, 0.0, Unit.PX, 25.0, Unit.PX);
		
		Test.add(new RPCanvas());
		RPCanvas.activate();
		
		setWidget(Test);
		
	}
}
