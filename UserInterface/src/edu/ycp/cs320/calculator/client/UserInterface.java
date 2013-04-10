package edu.ycp.cs320.calculator.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class UserInterface implements EntryPoint {

	private static String[] IMAGE_FILES = {
		"slidepad_blue.jpg",
		"slidepad_green.jpg",
		"slidepad_red.jpg",
		"slidepad_yellow.jpg",
		"startzone_blue.jpg",
		"startzone_green.jpg",
		"startzone_red.jpg",
		"startzone_yellow.jpg",
		"stoppad.jpg",
		"winzone_botleft.jpg",
		"winzone_botright.jpg",
		"winzone_topleft.jpg",
		"winzone_topright.jpg",
		"lobby_screen2.png"
	};
	
	private static Map<String, Image> IMAGE_MAP = new HashMap<String, Image>();
	
	// Entry point method.
	public void onModuleLoad() {

		GameLobby lobby = new GameLobby();
		GWT.log("Lobby created.");
		
		GameLobby.update();
	
		RootLayoutPanel.get().add(lobby);
		RootLayoutPanel.get().setWidgetLeftRight(lobby, 0.0, Unit.PX, 0.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(lobby, 0.0, Unit.PX, 0.0, Unit.PX);
		GWT.log("Lobby added to root layout panel.");
		
		// Create a hidden panel in which sprite images can be loaded.
		FlowPanel hiddenPanel = new FlowPanel();
		hiddenPanel.setSize("0px","0px");
		RootLayoutPanel.get().add(hiddenPanel);
		RootLayoutPanel.get().setWidgetRightWidth(hiddenPanel, 0.0, Unit.PX, 0.0, Unit.PX);
		RootLayoutPanel.get().setWidgetBottomHeight(hiddenPanel, 0.0, Unit.PX, 0.0, Unit.PX);
		GWT.log("Hidden image panel created.");
		
		// Load sprites
		GWT.log("Loading sprites...");
		for (String spriteFile : IMAGE_FILES) {
			String url = GWT.getModuleBaseForStaticFiles() + spriteFile;
			Image img = new Image(url);
			hiddenPanel.add(img);
			IMAGE_MAP.put(spriteFile, img);
		}
		GWT.log("Finished loading sprites.");
	}
	
	public static Image getImage(String spriteFile) {
		Image image = IMAGE_MAP.get(spriteFile);
		if (image == null) {
			GWT.log("Unknown image: " + spriteFile);
		}
		return image;
	}
}
