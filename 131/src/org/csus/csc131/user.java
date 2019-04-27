/*
 * User class for storing user information
 */

public class user {
	
	private enum status {LOST, FOUND};
	private int userID;
	private int tagID; //should this be a tag class?
	private status tagStatus;
	private String userName; //do we need this and userID??

	
	public int getUserID() {
		return userID;
	}
	
	public int getTagID() {
		return tagID;
	}
	
	public status getTagStatus() {
		return tagStatus;
	}
	
	public String UserName() {
		return userName;
	}
	
	public void setLost() {
		tagStatus = status.LOST;
	}	
	
	public void setFound() {
		tagStatus = status.FOUND;
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
