package edu.ycp.cs320.calculator.shared;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class Game_Window extends PopupPanel{
	
	Label pos = new Label();
	
	String choice = "";
	String notSup = "Canvas is not supported by browser!";
	int height = 500;
	int width = 500;
	int refreshRate = 10;
	int mouseX, mouseY;
	
	CssColor redrawColor = CssColor.make("rgba(255,255,255,0)");
	
	Canvas gameBoard;
	Canvas boardBack;
	Context2d context;
	Context2d backContext;
	
	
	public Game_Window(String game){
		super(true);
		LayoutPanel Test = new LayoutPanel();
		
		Label playGame = new Label(game);
		playGame.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		Test.add(playGame);
		
		choice = game;
		
		pos.setText(mouseX + ", " + mouseY);		
		Test.add(pos);
		
		setWidget(Test);
		
	}
	
	public void onModuleLoad(){
		gameBoard = Canvas.createIfSupported();     
		boardBack = Canvas.createIfSupported();     
		if (gameBoard == null) {       
			RootPanel.get(choice).add(new Label(notSup));      
			return;     
		} 
		
			
		gameBoard.setWidth(width + "px");     
		gameBoard.setHeight(height + "px");    
		gameBoard.setCoordinateSpaceWidth(width);    
		gameBoard.setCoordinateSpaceHeight(height);    
		boardBack.setCoordinateSpaceWidth(width);    
		boardBack.setCoordinateSpaceHeight(height);     
		RootPanel.get(choice).add(gameBoard);     
		context = gameBoard.getContext2d();     
		//backContext = boardBack.getContext2d();
		
		initHandlers();          
		// setup timer     
		final Timer timer = new Timer() {      
			@Override       
			public void run() {         
				doUpdate();
				paint();
			}    
		};     
		
		timer.scheduleRepeating(refreshRate);   
	}
		
	void doUpdate() {     

	}
	

	void initHandlers() {    
		gameBoard.addMouseMoveHandler(new MouseMoveHandler() {
		public void onMouseMove(MouseMoveEvent event) {        
			mouseX = event.getRelativeX(gameBoard.getElement());        
			mouseY = event.getRelativeY(gameBoard.getElement());
		}     
		});      
	}
	
	void paint(){
		backContext.setFillStyle("black");
		backContext.fillRect(0, 0, width, height);
	}
}


