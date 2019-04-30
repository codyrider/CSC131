package org.csus.csc131;
import java.util.Scanner;
import java.lang.String;
import java.lang.*;

public class main {
	public static void main(String[] args) {
		
		server ser = new server();
		
		Scanner input = new Scanner(System.in);
		System.out.println("--------------------------------------");
		System.out.println("-           Test Run Program         -");
		System.out.println("--------------------------------------\n\n");
		System.out.println("(1) New User (2) Existing User \n");
		System.out.println(" Select out of the two options: ");
		int menu1 = input.nextInt();
		switch(menu1) {
		case 1:
			System.out.println("Create unique User ID: ");
			int newUser = input.nextInt();
			ser.addUser(newUser);
			System.out.println(" UserId Successfully Created! \n\n");
			
			break;
		case 2:
			System.out.println("Enter in your unique User ID: ");
			int existingUser = input.nextInt();
			while(ser.userExists(existingUser) != true) {
				System.out.println("User ID Not Found - Try Again: ");
				existingUser = input.nextInt();
			}
			System.out.println(" Login Successful! \n\n");
			break;
		default:
			System.out.println(" Invalid Input :( \n\n");
			break;
							
		}
		return;
				
	}

}
