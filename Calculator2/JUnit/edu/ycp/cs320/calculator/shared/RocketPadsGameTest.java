package edu.ycp.cs320.calculator.shared;

import junit.framework.TestCase;

public class RocketPadsGameTest extends TestCase{
	RocketPadsGame testGame;
		
	public void testWin(){
		testGame.setWin(false);
		assertEquals(false, testGame.checkWin());
		
		testGame.setWin(true);
		assertEquals(true, testGame.checkWin());
	}
	
	public void testGetPlayers(){
		assertEquals(1, testGame.get_num_players());
	}
}
