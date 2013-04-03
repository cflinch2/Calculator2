package edu.ycp.cs320.calculator.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
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
		timer.scheduleRepeating(1000/30);
	}
	
	// Render the scene.
	protected void paint() {
		// Draw onto the buffer.
		
		// Draw background.
		buff_context.setFillStyle("black");
		buff_context.fillRect(0, 0, 900, 900);
		
		// Draw players.
		
		// Copy buffer onto main canvas.
		context.drawImage((CanvasElement) buffer.getElement().cast(),0,0);
	}
}
