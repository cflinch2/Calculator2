package edu.ycp.cs320.calculator.shared;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;

public class Test_Canvas extends Composite {

	String choice = "";
	String notSup = "Canvas is not supported by browser!";
	int height = 500;
	int width = 500;
	int refreshRate = 10;
	int mouseX, mouseY;
	
	CssColor redrawColor = CssColor.make("rgba(255,255,255,0)");
	Timer timer;
	Canvas gameBoard;
	Canvas boardBack;
	Context2d context;
	Context2d backContext;
	
	public Test_Canvas(){
		FocusPanel panel = new FocusPanel();
		panel.setSize("700px", "500px");
		
		Label junk = new Label("Maybe");
		panel.add(junk);
		
		
		this.boardBack = Canvas.createIfSupported();
		boardBack.setSize("700px", "500px");
		boardBack.setCoordinateSpaceWidth(width);
		boardBack.setCoordinateSpaceHeight(height);
		this.backContext = boardBack.getContext2d();
		
		this.gameBoard = Canvas.createIfSupported();
		gameBoard.setSize("700px", "500px");
		gameBoard.setCoordinateSpaceWidth(width);
		gameBoard.setCoordinateSpaceHeight(height);
		this.context = gameBoard.getContext2d();
		
		
		
		
		this.timer = new Timer() {      
			@Override       
			public void run() {         
				paint();
			}    
		};
		
		initWidget(panel);
		
	}
	
	public void activate(){
		timer.scheduleRepeating(1000/3);
	}
	
	void paint(){
		backContext.setFillStyle("black");
		backContext.fillRect(0, 0, width, height);
	}
	
}
