package edu.ycp.cs320.calculator.shared;

public class RocketPadsController {
	public RocketPadsController() {
		
	}
	
	public void updateGame(RocketPadsGame game) {
		
		RocketPadsPlayer player = game.getPlayer();

		// Update position of the player.
		updatePosition(player);
		
		// Get new direction for the player.
		updateDirection(player, game);
		
		// Check win condition.
		if(player.getDirection() == RocketPadsDirection.WIN)
			game.setWin(true);

	}

	private void updatePosition(RocketPadsPlayer player) {
		if(player.getDirection() == RocketPadsDirection.NORTH) {
			player.setLocation(player.getLocation().getX(),player.getLocation().getY()-75);
		} else if(player.getDirection() == RocketPadsDirection.SOUTH) {
			player.setLocation(player.getLocation().getX(),player.getLocation().getY()+75);
		} else if(player.getDirection() == RocketPadsDirection.EAST) {
			player.setLocation(player.getLocation().getX()+75,player.getLocation().getY());
		} else if(player.getDirection() == RocketPadsDirection.WEST) {
			player.setLocation(player.getLocation().getX()-75,player.getLocation().getY());
		}
	}
	
	private void updateDirection(RocketPadsPlayer player, RocketPadsGame game) {
		RocketPadsLocation location = player.getLocation();
		int col = location.getX()/75;
		int row = location.getY()/75;
		RocketPadsDirection pad = game.getPad(col,row);
		player.setDirection(pad);
	}
}
