package org.csus.csc131;
import java.util.Scanner;
import java.io.IOException;
import java.lang.*;



public class main {
	
	static Scanner input = new Scanner(System.in); //global variable for getting input
	static device dev = new device();
	static int tagID;
	
	
	public static void main(String[] args) throws IOException {
				
		System.out.println("-------------------------------------------------------");
		System.out.println("-                   Test Run Program                  -");
		System.out.println("-------------------------------------------------------\n\n");
		menu1();
	}
		
	public static void menu1() throws IOException {
		System.out.println("\n\n----------------------------------------------------------------------------------------------------\n");
		System.out.println("(1) New User (2) Existing User (3)Run from tag (4) Quit \n");
		System.out.println("Select out of the two options: ");
		int menu1 = input.nextInt();
		switch(menu1) {
		case 1:
			System.out.println("Create unique User ID: ");
			int newUser = input.nextInt();
			dev.createUser(newUser);
			System.out.println("UserId Successfully Created! \n\n");
			menu2(newUser);
			break;
		case 2:
			System.out.println("Enter in your unique User ID: ");
			int existingUser = input.nextInt();
			while(dev.logIn(existingUser) != true) {
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
			System.out.println(tagID);
			dev.tagFound(tagID);
			break;
		case 4:
			System.out.println("Goodbye! \n");
			break;
		default:
			System.out.println("Invalid Input :( ");
			//invalid input handler
			menu1();
							
		}		
	}
	
	public static void menu2(int uid) throws IOException {
		System.out.println("\n\n----------------------------------------------------------------------------------------------------\n");
		System.out.println("(1) Register an item (2) Report lost item (3) Check item status\n");
		System.out.println("(4) Logout (5) Quit\n");
		System.out.println("Select out of the six options: ");
		int menu2 = input.nextInt();
		switch(menu2) {
		case 1:
			tag tag1 = new tag();
			tagID = tag.getTagID();
			System.out.println(tagID);
			
			System.out.println("Please enter in your item ID: ");
			tagID = input.nextInt();
			//device newdev = new device(uid); //create a device object passing in uid to link object to the user
			dev.addTag(uid, tagID); //add the device via itemID into database linking it to it's owner
			System.out.println("Device successfully added \n");
			menu2(uid);
			break;
		case 2:
			System.out.println("Please enter in tag ID of your lost item: ");
			int lostTagID = input.nextInt();
			//device lostDev = new device();
			dev.setLost(lostTagID);
			System.out.println("Item "+lostTagID+" has been set to lost.\n");
			menu2(uid);
			break;
		case 3:
			System.out.println("Enter tagID: \n");
			System.out.println("Status: " + dev.checkStatus(uid,input.nextInt()));
			menu2(uid);
			break;
		case 4:
			menu1();
			break;
		case 5:
			System.out.println("Goodbye! \n");
			break;
		default:
			System.out.println(" Invalid Input :( ");
			//invalid input handler
			menu2(uid);
			
		}
	}
}

