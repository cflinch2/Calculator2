package edu.ycp.cs320.calculator.shared;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class Game_Window extends PopupPanel{
	
	public Game_Window(String game){
		super(true);
		setWidget(new Label(game));
	}
	
	

}


