package edu.ycp.cs320.calculator.shared;

import java.io.Serializable;

public class User implements Serializable {
	
	private int id;
	private String username, password;
	
	private AvatarList avatar;
	
	public User() {
		
	}
	
	public User(int id, String username, String password, AvatarList avatar) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.avatar = avatar;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setAvatar(AvatarList avatar) {
		this.avatar = avatar;
	}
	
	public AvatarList getAvatar() {
		return avatar;
	}
}
