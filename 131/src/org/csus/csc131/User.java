package org.csus.csc131;
/*
 * User class for storing user information
 */

public class User {
	
	private int userID;
	private int tagID;
	private String tagStatus;

//constructors	
	public User(int userID) {
		this.userID = userID;
	}

	public User(int userID, int tagID, String tagStatus) {
		this.userID = userID;
		this.tagID = tagID;
		this.tagStatus = tagStatus;
	}

	
//retrieve UserID
	public int getUserID() {
		return userID;
	}

//retrieve tagID
	public int getTagID() {
		return tagID;
	}
	
//retrieve status of tag; lost or found
	public String getTagStatus() {
		return tagStatus;
	}

//set status of tag to lost
	public void setLost() {
		tagStatus = "lost";
	}	

//set status of tag to found
	public void setFound() {
		tagStatus = "found";
	}

//assign tag to user
	public void setTagID(int tag) {
		tagID = tag;
	}

//assign userID to user
	public void setUserID(int id) {
		userID = id;
	}
	
}
