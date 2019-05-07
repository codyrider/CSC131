package org.csus.csc131;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class create Tag ID
 * @author Hung Ming, Liang
 * @version 6 May 2019
 */

public class tag {

	private static int tagID;
	
	/**
		* Initializes tag class
		* get number from file and set as tagID
		* update tagID in txt file
	*/
	public tag() throws IOException{
		tagID = createID();
		increaseID();
	}
	
	/**
		* return tagID;
	*/
	public static int getTagID()
	{
		return tagID;
	}
	
	/**
		* Read txt File and set new tag ID;
	*/
	private int createID()throws IOException{
		int a=0;
      
		Scanner scan=new Scanner(new File("tagID.txt"));//read tagID.txt for tagID
			
		a=scan.nextInt();
			
		return a;
	}
	
	/**
		* write txt file and update id number;
	*/
	private void increaseID() throws IOException{
		
		
		FileWriter writer = new FileWriter("tagID.txt");
			int a=tagID+1;
			writer.write(String.valueOf(a));//write new number to tagID.txt
			writer.close();
		}
	
}
