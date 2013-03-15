package edu.ycp.cs320.calculator.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.dom.client.Style.Unit;
/*import com.google.gwt.user.client.ui.TextBox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;*/

public class Game_Play extends Composite {
	
	private LayoutPanel gPlay;
	private InlineLabel ID;
	
	public Game_Play(){
		
		gPlay = new LayoutPanel();
		initWidget(gPlay);
		gPlay.setSize("1000px", "750px");
		
		ID = new InlineLabel("Game Page");
		gPlay.add(ID);
		gPlay.setWidgetLeftWidth(ID, 0.0, Unit.PX, 1000.0, Unit.PX);
		gPlay.setWidgetTopHeight(ID, 0.0, Unit.PX, 750.0, Unit.PX);
		
		
		
	}
}
