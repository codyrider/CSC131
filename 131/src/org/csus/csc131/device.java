import java.util.concurrent.ThreadLocalRandom;
/**
 * A class set device
 * Use userID to contact server and add, check or set
 * @author Hung Ming, Liang
 * @version 26 April 2019
 */

public class device{
	
	private int userID;
	private server ser;
	private user tag;
	private String[] coordinate = new String[2];
	
	
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
		
		/**
		* generate two random double numbers 
		* store them in a double array
		* return the array
		*/
		public String[] coordinateGenerator() {
			coordinate[0] = Double.toString(ThreadLocalRandom.current().nextDouble(-85.0, 86.0));
			coordinate[1] = Double.toString(ThreadLocalRandom.current().nextDouble(-180.0, 181.0));
			
			return coordinate;
		}
		
		/**
		* tag.getTagID() from user class
		* send GPS coordinate and tagID to the server to update tag found
		*/
		public void tagFound() {
			ser.tagFound(tag.getTagID(), coordinateGenerator());
		}
}
