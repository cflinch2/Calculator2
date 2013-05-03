package edu.ycp.cs320.calculator.shared;

import org.junit.Before;
import org.junit.Test;

public class RocketPadsControllerTest {

private RocketPadsLocation testLocationA, testLocationB, testLocationC, testLocationD;
private RocketPadsPlayer testPlayer;
private RocketPadsController testController;

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
	
	protected void setUpControllerTest() throws Exception 
	{
		testLocationA = new RocketPadsLocation(0,75);
		testLocationB = new RocketPadsLocation(0,0);
		testLocationC = new RocketPadsLocation(5,5);
		testLocationD = new RocketPadsLocation(5,5);
		RocketPadsDirection start_dir = RocketPadsDirection.NORTH;
		testPlayer = new RocketPadsPlayer(testLocationA, start_dir);
		RocketPadsBoardData data1 = RocketPadsCreateBoardDataFromArray.createFromArray(tutorial, BoardList.Tutorial);
		RocketPadsGame testModel = new RocketPadsGame(data1);
		testController = new RocketPadsController();
		testPlayer = testModel.getPlayer();
		
		
	}
	
	
	
	
	@Before
	public void setUp() throws Exception
	{
		RocketPadsDirection start_dir = RocketPadsDirection.NORTH;
		RocketPadsPlayer testPlayer = new RocketPadsPlayer(testLocationA, start_dir);
	}
	
	@Test
	public void testUpdatedPositionNORTH() throws Exception
	{
		
		//assertEquals(0, testPlayer.getY());
	}
	
	//if(player.getDirection() == RocketPadsDirection.NORTH) {
//		player.setLocation(player.getLocation().getX(),player.getLocation().getY()-75);
}
