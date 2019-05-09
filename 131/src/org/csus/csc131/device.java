package org.csus.csc131;

import java.util.concurrent.ThreadLocalRandom;
import java.lang.String;
/**
 * A class set device
 * Use userID to contact server and add, check or set
 * @author Hung Ming, Liang
 * @version 26 April 2019
 */

public class device{
	
	@SuppressWarnings("unused")
	private int userID;
	private server ser;
	private double[] coordinate = new double[2];
	
		
	public device()
	{
		ser = server.getInstance();
	}	
	
		/**
		* Initializes userID and server
		* @param id is userID pass in
		*/
	
		public device(int id){
			userID=id;
			ser=new server();
		}
		
		/**
		* Initializes userID and set server
		* @param id is userID pass in 
		* @param se is server object pass in
		*/
		
		public device(int id,server se){
			ser=se;
			userID=id;
		}
		
		/**
		* sent tagID and userID to server to add TAG
		* @param tagID is tagID pass in 
		*/
		public void addTag(int userID, int tagID){
			server.addTag(userID,tagID);
		}
		
		/**
		* sent userID to server to check TAG status
		*/
		public String checkStatus(int userID, int tagID){
			return ser.checkTagStatus(tagID);
		}
		
		/**
		* sent userID to server to set TAG lost
		*/
		public void setLost(int tagID){
			ser.setLost(tagID);	
		}
		
		/**
		* generate two random double numbers 
		* store them in a double array
		* return the array
		*/
		public double[] coordinateGenerator() {
			coordinate[0] = ThreadLocalRandom.current().nextDouble(-85.0, 86.0);
			coordinate[1] = ThreadLocalRandom.current().nextDouble(-180.0, 181.0);
			
			return coordinate;
		}
		
		/**
		* tag.getTagID() from user class
		* send GPS coordinate and tagID to the server to update tag found
		*/
		public void tagFound(int tagID) {
			ser.tagFound(tagID, coordinateGenerator());
		}
		
		//Sends user id to the server to determine if the user exists
		public boolean logIn(int UID)
		{
			if(ser.userExists(UID) == true)
				return true;
			else
				return false;
		}
		
		//sends user id to the server to register user in the database
		public void createUser(int uid)
		{
			ser.addUser(uid);
		}
}
