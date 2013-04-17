package edu.ycp.cs320.calculator.shared;

import java.util.ArrayList;

public class RocketPadsController {
	public RocketPadsController() {
		
	}
	
	public void updateGame(RocketPadsGame game) {
		
		ArrayList<RocketPadsPlayer> player_list = game.getPlayerList();
		
		// Update player positions.
		for(int i = 0; i < player_list.size(); i++) {
			RocketPadsPlayer player = player_list.get(i);

			updatePosition(player);
			setNewDirection(player, game);
			
			// Check win condition for each player.
			if(player.getDirection() == RocketPadsDirection.WIN)
				game.setWin(true);
		}
	}

	private void updatePosition(RocketPadsPlayer player) {
		if (player.getDirection() == RocketPadsDirection.NORTH) {
			player.setLocation(player.getLocation().getX(),player.getLocation().getY()-75);
		} else if(player.getDirection() == RocketPadsDirection.SOUTH) {
			player.setLocation(player.getLocation().getX(),player.getLocation().getY()+75);
		} else if(player.getDirection() == RocketPadsDirection.EAST) {
			player.setLocation(player.getLocation().getX()+75,player.getLocation().getY());
		} else if(player.getDirection() == RocketPadsDirection.WEST) {
			player.setLocation(player.getLocation().getX()-75,player.getLocation().getY());
		}
	}
	
	private void setNewDirection(RocketPadsPlayer player, RocketPadsGame game) {
		player.setDirection(game.getPad(player.getLocation().getX()/75,player.getLocation().getY()/75));
	}
}
