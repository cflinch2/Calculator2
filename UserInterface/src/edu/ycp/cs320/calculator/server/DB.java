package edu.ycp.cs320.calculator.server;

import edu.ycp.cs320.calculator.shared.IDatabase;

public class DB {

	private static final IDatabase theInstance = new DerbyDatabase();// new FakeDatabase(); // change this to "real" database at some point
	
	public static IDatabase instance() {
		return theInstance;
	}

}
