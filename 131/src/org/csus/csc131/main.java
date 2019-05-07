package org.csus.csc131;
import java.util.Scanner;
import java.lang.*;



public class main {
	
	static Scanner input = new Scanner(System.in); //global variable for getting input
	static server ser = new server(); //global server object;
	
	public static void main(String[] args) {
				
		System.out.println("-------------------------------------------------------");
		System.out.println("-                   Test Run Program                  -");
		System.out.println("-------------------------------------------------------\n\n");
		menu1();
	}
		
	public static void menu1() {
		System.out.println("\n\n----------------------------------------------------------------------------------------------------\n");
		System.out.println("(1) New User (2) Existing User (3) Quit \n");
		System.out.println("Select out of the two options: ");
		int menu1 = input.nextInt();
		switch(menu1) {
		case 1:
			System.out.println("Create unique User ID: ");
			int newUser = input.nextInt();
			ser.addUser(newUser);
			System.out.println("UserId Successfully Created! \n\n");
			menu2(newUser);
			break;
		case 2:
			System.out.println("Enter in your unique User ID: ");
			int existingUser = input.nextInt();
			while(ser.userExists(existingUser) != true) {
				System.out.println("User ID Not Found - Try Again (0 to quit): ");
				existingUser = input.nextInt();
				if(existingUser == 0) {
					System.out.println("Goodbye! \n");
					return; 
				}
				else 
					continue;
			}
			System.out.println("Login Successful! \n\n");
			menu2(existingUser);
			break;
		case 3:
			System.out.println("Goodbye! \n");
			break;
		default:
			System.out.println("Invalid Input :( ");
			//invalid input handler
			menu1();
							
		}		
	}
	
	public static void menu2(int uid) {
		System.out.println("\n\n----------------------------------------------------------------------------------------------------\n");
		System.out.println("(1) Register an item (2) Report found item (3) Report lost item (4) Check item status\n");
		System.out.println("(5) Logout (6) Quit\n");
		System.out.println("Select out of the six options: ");
		int menu2 = input.nextInt();
		switch(menu2) {
		case 1:
			System.out.println("Please enter in your item ID: ");
			int tagID = input.nextInt();
			device newdev = new device(uid); //create a device object passing in uid to link object to the user
			newdev.addTag(tagID); //add the device via itemID into database linking it to it's owner
			System.out.println("Device successfully added \n");
			//menu2(uid);
			break;
		case 2:
			System.out.println("Please enter in item ID that is found: ");
			int foundTagID = input.nextInt();
			device foundDev = new device();
			double[] gps = {10101,99901};
			//device class needs to establish a constructor for found device without knowing userID
			ser.tagFound(foundTagID,gps);
			System.out.println("Item "+foundTagID+" has been set to found!\n");
			menu2(uid);
			break;
		case 3:
			System.out.println("Please enter in tag ID of your lost item: ");
			int lostTagID = input.nextInt();
			device lostDev = new device();
			lostDev.setLost(lostTagID);
			System.out.println("Item "+lostTagID+" has been set to lost.\n");
			menu2(uid);
			break;
		case 4:
			//User user = new User(uid);
			System.out.println("Status: "+ser.checkTagStatus(uid));
			menu2(uid);
			break;
		case 5:
			menu1();
			break;
		case 6:
			System.out.println("Goodbye! \n");
			break;
		default:
			System.out.println(" Invalid Input :( ");
			//invalid input handler
			menu2(uid);
			
		}
	}
}

