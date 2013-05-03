package edu.ycp.cs320.calculator.shared;

public interface IDatabase {
	public RocketPadsBoardData getBoardData(BoardList board);
	public User createUser(int id, String username, String password, AvatarList avatar);
}
