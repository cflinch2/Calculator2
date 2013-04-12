package edu.ycp.cs320.calculator.shared;

import java.util.ArrayList;

public class RocketPadsController {
	public RocketPadsController() {
		
	}
	
	public void updateGame(RocketPadsGame game) {
		
		ArrayList<RocketPadsPlayer> player_list = game.getPlayerList();
		
		// Update player positions.
		for(int i = 0; i < player_list.size(); i++) {
			updatePosition(player_list.get(i));
		}
	}

	private void updatePosition(RocketPadsPlayer player) {
		if (player.getSlide() == true) {
			if (player.getDirection() == RocketPadsDirection.NORTH) {
				player.setLocation(player.getLocation().getX(),player.getLocation().getY()-1);
			}
			else if(player.getDirection() == RocketPadsDirection.SOUTH) {
				//y increases
				player.setLocation(player.getLocation().getX(),player.getLocation().getY()+1);
			}
			else if(player.getDirection() == RocketPadsDirection.EAST) {
				//x increases
				player.setLocation(player.getLocation().getX()+1,player.getLocation().getY());
			}
			else if(player.getDirection() == RocketPadsDirection.WEST) {
				player.setLocation(player.getLocation().getX()-1,player.getLocation().getY()-1);
			}
		}
	}
}
