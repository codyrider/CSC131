package org.csus.csc131;

import java.io.BufferedReader;
import java.io.File;
import java.util.*; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.String;

//Implement iterator, factory method, observer, singleton

public class server 
{
	//Delimiters for reading in user information from the file
	private static final int USER_ID_IDX = 0;
    private static final int TAG_ID_IDX = 1;
    private static final int TAG_STATUS_IDX = 2;
    
    //This writes data to the database file after the information is edited
    private static void writeCsvFile(ArrayList<User> users)
    {
    	//create a file writer
        FileWriter fileWriter = null;
                 
        try 
        {
        	File database = new File("database.csv");
            database.createNewFile();
            fileWriter = new FileWriter("database.csv");
             
            //Write the list of users to the database file
            for (User user : users) 
            {
            	fileWriter.append(String.valueOf(user.getUserID()));
    	        fileWriter.append(",");
    	        fileWriter.append(String.valueOf(user.getTagID()));
    	        fileWriter.append(",");
    	        fileWriter.append(String.valueOf(user.getTagStatus()));
    	        fileWriter.append("\n");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error in CsvFileWriter");
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                fileWriter.flush();
                fileWriter.close();
            } 
            catch (IOException e) 
            {
                System.out.println("Error while flushing/closing fileWriter");
                e.printStackTrace();
            } 
        }
    }
    
    private static ArrayList<User> readCsvFile() 
    {
    	//Create a new buffered reader
        BufferedReader fileReader = null;
      
        //Create a new list of users to hold data from the database file
        List<User> users = new ArrayList<User>();
        
        try 
        {
            String line = "";
             
            //Create the file reader
            File database = new File("database.csv");
            database.createNewFile();
            fileReader = new BufferedReader(new FileReader("database.csv"));
             
            //Read the file line by line
            while ((line = fileReader.readLine()) != null)
            {
                //Get all tokens available in line
                String[] tokens = line.split(",");
                if (tokens.length > 0) 
                {
                    //Create a new user object and fill with user information from database file
                	User user = new User(Integer.parseInt(tokens[USER_ID_IDX]), Integer.parseInt(tokens[TAG_ID_IDX]), tokens[TAG_STATUS_IDX]);
                    //Add the created user to the users list
                	users.add(user);
                }
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error in CsvFileReader");
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                fileReader.close();
            } 
            catch (IOException e) 
            {
                System.out.println("Error while closing fileReader");
                e.printStackTrace();
            }
        }
        return (ArrayList<User>) users;
    }
    
    //Adds a tag to a user in the database
	public static void addTag(int userID, int tagID)
	{
		//Read user data in from the database file
		ArrayList<User> users = readCsvFile();
		
		//Iterate through the user data to find the user ID
		/*
		ListIterator<User> iterator = users.listIterator();
		while (iterator.hasNext()) 
        {
			//If we find the user in the database add the tag ID to the user
            if(iterator.next().getUserID() == userID)
            {
            	iterator.next().setTagID(tagID);
            }
        }
        */
		
		for (User user : users) 
        {
			//If the user is found get the status of the users tag
            if(user.getUserID() == userID)
            {
            	user.setTagID(tagID);
            }
        }
		//Write the data to the database file
        writeCsvFile(users);
	}
	
	//Add a new user to the database
	public void addUser(int userID)
	{
		//Read user data in from the database file
		ArrayList<User> users = readCsvFile();
		
		User user = new User(userID);
        users.add(user);
        
        //Write the data to the database file
        writeCsvFile(users);
	}
	
	public String checkTagStatus(int tagID)
	{
		String result = "";
		//Read user data in from the database file
		ArrayList<User> users = readCsvFile();
		
		//Iterate through users to locate correct user
		for (User user : users) 
        {
			//If the user is found get the status of the users tag
            if(user.getTagID() == tagID)
            {
            	result = user.getTagStatus();
            }
            else
            	System.out.println("not found");
        }
        
		//Write the data to the database file
        writeCsvFile(users);
		return result;
	}
	
	public void setLost(int tagID)
	{
		//Read user data in from the database file
		ArrayList<User> users = readCsvFile();
		
		//Iterate through users till the correct user is located
		for (User user : users) 
        {
			//If the user is found set the tag status to lost
            if(user.getTagID() == tagID)
            {
            	user.setLost();
            	System.out.println("Tag 111 set to lost \n");
            }
        }
        
		//Write the data to the database file
        writeCsvFile(users);
	}
	
	public void tagFound(int tagID, double[] GPS)
	{
		//Read user data in from the database file
		ArrayList<User> users = readCsvFile();
		
		//Iterate through the user list to find the correct user that is assigned the tagID
		for (User user : users) 
        {
			//If a user is located with the tagID, set the tag status to found and notify the user
            if(user.getTagID() == tagID && user.getTagStatus().equals("lost"))
            {
            	user.setFound();
            	//Represents the notification of the user until further implementation
            	System.out.println("Tag " + user.getTagID() + " was found at GPS coordinates: " + GPS[0] + "," + GPS[1]);
            }
            else
            	System.out.println("not found");
        }
        
		//Write the data to the database file
        writeCsvFile(users);
	}
	
	public boolean userExists(int userID)
	{
		//Return value for the existence of a user in the database
		boolean exists = false;
		//Read user data in from the database file
		ArrayList<User> users = readCsvFile();
		
		//Iterate through the user list to find the correct user
		for (User user : users) 
        {
			//If the user is found in the data base exists becomes true
            if(user.getUserID() == userID)
            {
            	exists = true;
            }
        }
        
		//Write the data to the database file
        writeCsvFile(users);
        
        return exists;
	}
}
