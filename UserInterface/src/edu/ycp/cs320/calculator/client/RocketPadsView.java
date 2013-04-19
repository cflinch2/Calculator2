package edu.ycp.cs320.calculator.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import edu.ycp.cs320.calculator.shared.RocketPadsController;
import edu.ycp.cs320.calculator.shared.RocketPadsDirection;
import edu.ycp.cs320.calculator.shared.RocketPadsGame;

public class RocketPadsView extends Composite {
	
	private static final Map<RocketPadsDirection, String> directionPadImageNames = new HashMap<RocketPadsDirection, String>();
	static {
		directionPadImageNames.put(RocketPadsDirection.EAST, "slidepad_red.jpg");
		directionPadImageNames.put(RocketPadsDirection.WEST, "slidepad_yellow.jpg");
		directionPadImageNames.put(RocketPadsDirection.NORTH, "slidepad_green.jpg");
		directionPadImageNames.put(RocketPadsDirection.SOUTH, "slidepad_blue.jpg");
		directionPadImageNames.put(RocketPadsDirection.START_RED, "startzone_red.jpg");
		directionPadImageNames.put(RocketPadsDirection.START_BLUE, "startzone_blue.jpg");
		directionPadImageNames.put(RocketPadsDirection.START_GREEN, "startzone_green.jpg");
		directionPadImageNames.put(RocketPadsDirection.START_YELLOW, "startzone_yellow.jpg");
		directionPadImageNames.put(RocketPadsDirection.WIN_RED, "winzone_topleft.jpg");
		directionPadImageNames.put(RocketPadsDirection.WIN_BLUE, "winzone_topright.jpg");
		directionPadImageNames.put(RocketPadsDirection.WIN_GREEN, "winzone_botleft.jpg");
		directionPadImageNames.put(RocketPadsDirection.WIN_YELLOW, "winzone_botright.jpg");
		directionPadImageNames.put(RocketPadsDirection.STOP, "stoppad.jpg");
	}
	
	private RocketPadsGame model;
	private RocketPadsController controller;
	private Canvas buffer;
	private Canvas canvas;
	private Context2d buff_context;
	private Context2d context;
	private Timer timer;
	double x = 12.5;
	double y = 12.5;
	double w = 50;
	double h = 50;
	
	

	public RocketPadsView() {
		// Create an instance of RocketPadsController.
		controller = new RocketPadsController();
		GWT.log("Controller object created.");
		
		// Create Focus Panel.
		FocusPanel panel = new FocusPanel();
		panel.setSize(RocketPadsGame.WIDTH + "px", RocketPadsGame.HEIGHT + "px");
		
		this.buffer = Canvas.createIfSupported();
		buffer.setSize("900px", "900px");
		buffer.setCoordinateSpaceWidth(RocketPadsGame.WIDTH);
		buffer.setCoordinateSpaceHeight(RocketPadsGame.HEIGHT);
		this.buff_context = buffer.getContext2d();
		GWT.log("Canvas buffer created.");
		
		this.canvas = Canvas.createIfSupported();
		canvas.setSize("900px", "900px");
		canvas.setCoordinateSpaceWidth(RocketPadsGame.WIDTH);
		canvas.setCoordinateSpaceHeight(RocketPadsGame.HEIGHT);
		this.context = canvas.getContext2d();
		panel.add(canvas);
		GWT.log("Main canvas created.");
		
		// Key handlers.
		canvas.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				handleKeyDown(event);
			}
		});
		
		/*
		canvas.addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {
				handleKeyUp(event);
			}
		});
		*/
		initWidget(panel);
		
		// Animation timer.
		this.timer = new Timer() {
			@Override
			public void run() {
				if(model != null) {
					controller.updateGame(model);
					paint();
				}
			}
		};
	}
	
	//Handles manual movement
	protected void handleKeyDown(KeyDownEvent event) {
		if (model.getPlayer(1).getDirection() == RocketPadsDirection.WALK)
		{
			if(event.isLeftArrow()) {
				// Handle left arrow event
				/*
				if (x > 50)
				{	
					x -= 75;
				}
				*/
				
				model.getPlayer(1).setDirection(RocketPadsDirection.WEST);
				
 			}
		
			
			if(event.isRightArrow()) {
				// Handle right arrow event
				/*
				if (x < 837.5)
				{	
					x += 75;
				}
				*/
				model.getPlayer(1).setDirection(RocketPadsDirection.EAST);
			}

			if(event.isDownArrow()) {
				// Handle down arrow event
				/*
				if (y < 837.5)
				{
					y += 75;
				}
				*/
				model.getPlayer(1).setDirection(RocketPadsDirection.SOUTH);
			}
			
			if(event.isUpArrow()) {
				// Handle up arrow event
				/*
				if (y > 75)
				{
					y -= 75;
				}
				*/
				model.getPlayer(1).setDirection(RocketPadsDirection.NORTH);
			}
		}
		
		 
	}
	
	
	// Set the game model instance.
	public void setModel(RocketPadsGame model) {
		this.model = model;
	}
	
	// Start the animation timer.
	public void activate() {
		timer.scheduleRepeating(1000/2);
	}
	
	// Render the scene.
	protected void paint() {
		// Draw background.
		buff_context.setFillStyle("black");
		buff_context.fillRect(0, 0, 900, 900);
		GWT.log("Black background filled.");
		
		GWT.log("Drawing images onto canvas...");
		for(int j = 0; j < model.getBoardHeight(); j++) {
			for(int i = 0; i < model.getBoardWidth(); i++) {
				// Find the pad at coordinates (i,j).
				RocketPadsDirection direction = model.getPad(i,j);
				
				String spriteFile = directionPadImageNames.get(direction);
				if (spriteFile == null) {
					throw new IllegalStateException("No sprite file for " + direction);
				}
				Image padImage = UserInterface.getImage(spriteFile);
				
				// Draw the pad image at the appropriate location.
				buff_context.drawImage((ImageElement)padImage.getElement().cast(), i*75, j*75);
			
				
			}
		}
		
		//draw player
		buff_context.setFillStyle("black");
		
		GWT.log("" + model.getPlayer(1).getLocation().getX() + ", " +  model.getPlayer(1).getLocation().getY());
		
		//buff_context.fillRect(12.5, 12.5, 50, 50);
		buff_context.fillRect(model.getPlayer(1).getLocation().getX() + 12.5, model.getPlayer(1).getLocation().getY() + 12.5, w, h);
		
		GWT.log("Finished drawing images.");
		
		// Copy buffer onto main canvas.
		context.drawImage((CanvasElement) buffer.getElement().cast(),0,0);
		
		
		
	}
}