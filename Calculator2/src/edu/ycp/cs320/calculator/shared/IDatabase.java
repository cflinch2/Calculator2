package edu.ycp.cs320.calculator.shared;

public interface IDatabase {
	public RocketPadsBoardData getBoardData(BoardList board);
	public User createUser(String username, String password, AvatarList avatar);
}
