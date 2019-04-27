/**
 * A class set device
 * Use userID to contact server and add, check or set
 * @author Hung Ming, Liang
 * @version 26 April 2019
 */

public class device{
	
	private int userID;
	private server ser;;
	
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
		public void addTag(int tagID){
			ser.addTag(userID,tagID);
		}
		
		/**
		* sent userID to server to check TAG status
		*/
		public String checkStatus(){
			return ser.checkTagStatus(userID);
		}
		
		/**
		* sent userID to server to set TAG lost
		*/
		public void setLost(){
			ser.setLost(userID);	
		}
		
}