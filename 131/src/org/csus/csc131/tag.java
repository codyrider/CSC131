package org.csus.csc131;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tag 
{
	private int tagID;
	
	public tag() throws IOException{
		tagID = createID();
		increaseID();
	}
	
	public int getTagID()
	{
		return tagID;
	}
	
	private int createID()throws IOException{
		int a=0;
      
		Scanner scan=new Scanner(new File("tagID.txt"));
			
		a=scan.nextInt();
			
		return a;
	}
	
	private void increaseID() throws IOException{
		
		
		FileWriter writer = new FileWriter("tagID.txt");
			int a=tagID+1;
			writer.write(String.valueOf(a));
			writer.close();
		}
	
}
