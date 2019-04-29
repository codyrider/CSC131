package org.csus.csc131;
/*
 * User class for storing user information
 */

public class User {
	
	private int userID;
	private int tagID; //should this be a tag class?
	private String tagStatus;
	private String userName; //do we need this and userID??

	
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
	
	public String UserName() {
		return userName;
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
	
	public void setUserName(String name) { //need both username and userID?
		userName = name;
	}
	
	public void setUserID(int id) {
		userID = id;
	}
	
	public void setUserName() {
		
	}
	
}
