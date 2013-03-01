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

	public void testUpdatePosition() throws Exception
	{
		//
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
		testPlayer.setDirection(1);
		assertEquals(RocketPadsDirection.NORTH, testPlayer.getDirection());
		
		testPlayer.setDirection(2);
		assertEquals(2, testPlayer.getDirection());
		
		testPlayer.setDirection(3);
		assertEquals(3, testPlayer.getDirection());
		
		testPlayer.setDirection(4);
		assertEquals(4, testPlayer.getDirection());
		
		testPlayer.setDirection(5);
		assertEquals(5, testPlayer.getDirection());
		
		testPlayer.setDirection(6);
		assertEquals(6, testPlayer.getDirection());
		
		testPlayer.setDirection(7);
		assertEquals(7, testPlayer.getDirection());
		
	}
}