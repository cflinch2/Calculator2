package edu.ycp.cs320.calculator.shared;

import junit.framework.TestCase;

public class RocketPadsPlayerTest extends TestCase
{
	private RocketPadsPlayer testPlayer;

	@Override
	protected void setUp() throws Exception 
	{
		testPlayer = new RocketPadsPlayer();
	}

	public void testGetLocation() throws Exception
	{
		RocketPadsLocation test_loc = new RocketPadsLocation(0,0);
		assertEquals(1, test_loc.compareLocTo(testPlayer.getLocation()));
	}

	public void testSetLocation() throws Exception
	{
		RocketPadsLocation test_loc = new RocketPadsLocation(10,10);
		testPlayer.setLocation(10, 10);
		assertEquals(1, test_loc.compareLocTo(testPlayer.getLocation()));
	}

	public void testResetLocation() throws Exception
	{
		assertEquals(0, testPlayer.getLocation().getX());
		assertEquals(0, testPlayer.getLocation().getY());
	}

	public void testGetSlide() throws Exception
	{
		assertFalse(testPlayer.getSlide());
	}

	public void testSetSlide() throws Exception
	{
		testPlayer.setSlide(true);
		assertTrue(testPlayer.getSlide());
	}

	public void testSetDirection() throws Exception		
	/*
	NORTH,	1
	SOUTH,	2
	EAST,	3
	WEST,	4
	WALK,	5
	STOP,	6
	WIN;	7
	*/
	{
		testPlayer.setDirection(RocketPadsDirection.NORTH);
		assertEquals(RocketPadsDirection.NORTH, testPlayer.getDirection());
		
		testPlayer.setDirection(RocketPadsDirection.SOUTH);
		assertEquals(RocketPadsDirection.SOUTH, testPlayer.getDirection());
		
		testPlayer.setDirection(RocketPadsDirection.EAST);
		assertEquals(RocketPadsDirection.EAST, testPlayer.getDirection());
		
		testPlayer.setDirection(RocketPadsDirection.WEST);
		assertEquals(RocketPadsDirection.WEST, testPlayer.getDirection());
		
		testPlayer.setDirection(RocketPadsDirection.WALK);
		assertEquals(RocketPadsDirection.WALK, testPlayer.getDirection());
		
		testPlayer.setDirection(RocketPadsDirection.STOP);
		assertEquals(RocketPadsDirection.STOP, testPlayer.getDirection());
		
	}
}
