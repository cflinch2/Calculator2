package edu.ycp.cs320.calculator.shared;

import junit.framework.TestCase;

public class RocketPadsGameTest extends TestCase {
	RocketPadsGame testGame;
	private int[][] tutorial = {
		{6,3,3,3,3,3,3,3,3,3,3,2},
		{2,5,5,5,5,5,5,5,5,5,5,2},
		{2,5,5,5,5,5,5,5,5,5,5,2},
		{2,5,5,5,5,5,5,5,5,5,5,2},
		{2,5,5,5,5,5,5,5,5,5,5,2},
		{2,5,5,5,5,5,5,5,5,5,5,2},
		{2,5,5,5,5,5,5,5,5,5,5,2},
		{2,5,5,5,5,5,5,5,5,5,5,2},
		{2,5,5,5,5,5,5,5,5,5,5,2},
		{2,5,5,5,5,5,5,5,5,5,5,2},
		{2,5,5,5,5,5,5,5,5,5,5,2},
		{3,3,3,3,3,3,3,3,3,3,3,7}};
		
	public void setUp() {
		testGame = new RocketPadsGame(RocketPadsCreateBoardDataFromArray.createFromArray(tutorial, BoardList.Tutorial));
	}
	
	public void testWin() {
		testGame.setWin(false);
		assertEquals(false, testGame.checkWin());
		
		testGame.setWin(true);
		assertEquals(true, testGame.checkWin());
	}
	
	public void testGetPlayers() {
		assertEquals(1, testGame.get_num_players());
	}
	
	public void testGetPad() {
		assertEquals(RocketPadsDirection.STOP, testGame.getPad(1,1));		
	}
}
