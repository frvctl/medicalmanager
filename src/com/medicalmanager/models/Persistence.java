package com.medicalmanager.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistence {
	static File file = new File(System.getProperty("user.dir") + "/lib/test.txt");
	
	public static void prepareFile() throws FileNotFoundException{
		
	}
	
	public static void writeToFile(String input) throws IOException{
	 
	}
	
	public static void readAllPatients() throws IOException{
	
	}
	
	public ArrayList<String> splitPatient(String input){
		int startIndex = input.indexOf(",");
		int index = startIndex;
		int start = 0;
		String word;
		int finalIndex = input.lastIndexOf(",");
		ArrayList<String> words = new ArrayList<String>();
		
		while(index < finalIndex){
			word = input.substring(start, index);
			index = input.indexOf(",", index);
		}
		return words;
	}
}
