package org.csus.csc131;
/*
 * User class for storing user information
 */

public class User {
	
	private int userID;
	private int tagID;
	private String tagStatus;

	
	public User(int userID) {
		this.userID = userID;
	}

	public User(int userID, int tagID, String tagStatus) {
		this.userID = userID;
		this.tagID = tagID;
		this.tagStatus = tagStatus;
	}

	public int getUserID() {
		return userID;
	}
	
	public int getTagID() {
		return tagID;
	}
	
	public String getTagStatus() {
		return tagStatus;
	}
	
	public void setLost() {
		tagStatus = "lost";
	}	
	
	public void setFound() {
		tagStatus = "found";
	}
	
	public void setTagID(int tag) {
		tagID = tag;
	}
	
	public void setUserID(int id) {
		userID = id;
	}
	
	public void setUserName() {
		
	}
	
}
