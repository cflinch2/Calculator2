package edu.ycp.cs320.calculator.shared;

import java.util.ArrayList;

public class RocketPadsController {

	public RocketPadsController() {
		
	}
	
	public void updateGame(RocketPadsGame game) {
		
		ArrayList<RocketPadsPlayer> player_list = game.getPlayerList();
		
		// Update player positions.
		for(int i = 0; i < player_list.size(); i++) {
			getNewDirection(player_list.get(i), game);
			updatePosition(player_list.get(i));
			//getNewDirection(player_list.get(i), game);
		}
	}

	private void updatePosition(RocketPadsPlayer player) {
			if (player.getDirection() == RocketPadsDirection.NORTH) {
				//player.setLocation(player.getLocation().getX(),player.getLocation().getY()-1);
				//if(player.getLocation().getY() > 75)
				{
					player.getLocation().setY(player.getLocation().getY()-75);
				}
			}
			else if(player.getDirection() == RocketPadsDirection.SOUTH) {
				//y increases
				//player.setLocation(player.getLocation().getX(),player.getLocation().getY()+1);
				//if(player.getLocation().getY() < 837.5)
//				{
//					player.getLocation().setY(player.getLocation().getY()+75);
//				}
				player.setLocation(player.getLocation().getX(), player.getLocation().getY()+75);
			}
			else if(player.getDirection() == RocketPadsDirection.EAST) {
				//x increases
				//player.setLocation(player.getLocation().getX()+1,player.getLocation().getY());
				//if(player.getLocation().getX() < 837.5)
				{	
					player.getLocation().setX(player.getLocation().getX()+75);
				}
			}
			else if(player.getDirection() == RocketPadsDirection.WEST) {
				//player.setLocation(player.getLocation().getX()-1,player.getLocation().getY()-1);
				//if(player.getLocation().getX() > 75)
				{	
					player.getLocation().setX(player.getLocation().getX()-75);
				}
			}
			
			
	}
	private void getNewDirection(RocketPadsPlayer player, RocketPadsGame game){
		if (player.getDirection() == RocketPadsDirection.START_BLUE ||player.getDirection() == RocketPadsDirection.START_GREEN || player.getDirection() == RocketPadsDirection.START_GREEN || player.getDirection() == RocketPadsDirection.START_YELLOW || player.getDirection() == RocketPadsDirection.STOP)
		{
			player.setDirection(RocketPadsDirection.WALK);
		}
		else {
		int x = player.getLocation().getX()/75;
		int y = player.getLocation().getY()/75;
		player.setDirection(game.getPad(x, y));
		System.out.println("New direction is: " + player.getDirection());
		}
	}
		
	
}
