package edu.ycp.cs320.calculator.client;

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
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import edu.ycp.cs320.calculator.shared.RocketPadsController;
import edu.ycp.cs320.calculator.shared.RocketPadsGame;

public class RocketPadsView extends Composite {   
	private RocketPadsGame model;
	private RocketPadsController controller;
	private Canvas buffer;
	private Canvas canvas;
	private Context2d buff_context;
	private Context2d context;
	private Timer timer;
	private Image background;
	private Image slidepad_east, slidepad_west, slidepad_north, slidepad_south;
	private Image startzone_red, startzone_blue, startzone_green, startzone_yellow;
	private Image winzone_tl, winzone_tr, winzone_bl, winzone_br;
	private Image stoppad;

	public RocketPadsView() {
		// Create an instance of RocketPadsController.
		controller = new RocketPadsController();
		
		// Create Focus Panel.
		FocusPanel panel = new FocusPanel();
		panel.setSize(RocketPadsGame.WIDTH + "px", RocketPadsGame.HEIGHT + "px");
		
		this.buffer = Canvas.createIfSupported();
		buffer.setSize("900px", "900px");
		buffer.setCoordinateSpaceWidth(RocketPadsGame.WIDTH);
		buffer.setCoordinateSpaceHeight(RocketPadsGame.HEIGHT);
		this.buff_context = buffer.getContext2d();
		
		this.canvas = Canvas.createIfSupported();
		canvas.setSize("900px", "900px");
		canvas.setCoordinateSpaceWidth(RocketPadsGame.WIDTH);
		canvas.setCoordinateSpaceHeight(RocketPadsGame.HEIGHT);
		this.context = canvas.getContext2d();
		panel.add(canvas);
		
		// Key handlers.
		canvas.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				handleKeyDown(event);
			}
		});
		canvas.addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {
				handleKeyUp(event);
			}
		});
		
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
	
	protected void handleKeyDown(KeyDownEvent event) {
		if(event.isLeftArrow()) {
			// Handle left arrow event
		}
		if(event.isRightArrow()) {
			// Handle right arrow event
		}
		if(event.isDownArrow()) {
			// Handle down arrow event
		}
		if(event.isUpArrow()) {
			// Handle up arrow event
		}
	}
	
	protected void handleKeyUp(KeyUpEvent event) {
		if(event.isLeftArrow()) {
			// Handle left arrow event
		}
		if(event.isRightArrow()) {
			// Handle right arrow event
		}
		if(event.isDownArrow()) {
			// Handle down arrow event
		}
		if(event.isUpArrow()) {
			// Handle up arrow event
		}
	}
	
	// Set the game model instance.
	public void setModel(RocketPadsGame model) {
		this.model = model;
	}
	
	// Start the animation timer.
	public void activate() {
		//timer.scheduleRepeating(1000/30);
		timer.scheduleRepeating(1000/2);
		
		// Load images
		startzone_red = UserInterface.getImage("startzone_red.jpg");
	}
	
	public void set_startzone_red(Image startzone_red) {
		this.startzone_red = startzone_red;
	}
	
	// Render the scene.
	protected void paint() {
		// Draw background.
		buff_context.setFillStyle("black");
		buff_context.fillRect(0, 0, 900, 900);
		
		/*
		for (int j = 0; j < model.getBoardHeight(); j+=75) {
			for (int i = 0; i < model.getBoardWidth(); i+=75) {
				// Find the pad at coordinates i,j.
				
				// Find the pad image.
				Image padImage = ...
				
				// Draw the pad image at the appropriate location.
				buff_context.drawImage((ImageElement)padImage.getElement().cast(), i, j);
			}
		}
		*/
		
		// This is just a proof of concept
		buff_context.drawImage((ImageElement)startzone_red.getElement().cast(),0,0);
		
		// Copy buffer onto main canvas.
		context.drawImage((CanvasElement) buffer.getElement().cast(),0,0);
	}
}
