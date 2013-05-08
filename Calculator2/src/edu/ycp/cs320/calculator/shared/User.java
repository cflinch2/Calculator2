package edu.ycp.cs320.calculator.shared;

import java.io.Serializable;

public class User implements Serializable {
	
	private int id;
	private String username, password;
	
	private AvatarList avatar;
	
	public User(int id, String username, String password, AvatarList avatar) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.avatar = avatar;
	}
	
	public int getID() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public AvatarList getAvatar() {
		return avatar;
	}
}
