package com.medicalmanager.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistence {
	static File file = new File(System.getProperty("user.dir") + "/lib/test.txt");
	
	public static void prepareFile() throws FileNotFoundException{
		// Create a file if there is not one
	}
	
	public static void writeToFile(String input) throws IOException{
		// Helper function for writing the data to the file	
	}
	
	public static void readAllPatients() throws IOException{
		// Read everything from the file, parse it,
		// and then dump it into an array list. Probably
		// will need array list getters and setters in this
		// file, maybe. Idk.
	}
	
	public static String[] splitPatient(String input){
		int startIndex = input.indexOf(",");
		int finalIndex = input.lastIndexOf(",");
		int index = startIndex;
		
		int start = -1;
		int count = 2; // accounts for the first and last word
		
		String word;

		// Find size of the patients
		while(index < finalIndex){
			index = input.indexOf(",", index + 1);
			count++;
		}
		
		// create an array that is the size of the number of patient fields
		String[] words = new String[count]; 
		index = startIndex; //reset backs to the start

		// actually split the words
		for(int i = 0; i < count; i++){
			if(index < finalIndex){
				word = input.substring(start+1, index);
				start = input.indexOf(",", index);
				index = input.indexOf(",", index+1);
			}else{
				word = input.substring(finalIndex+1);
			}
			
			words[i] = word.trim();
			
		}
		
		return words;
	}
}

