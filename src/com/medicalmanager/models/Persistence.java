package com.medicalmanager.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistence {
	public static int[] allIDs;
	public static ArrayList<Patient> sortedList = new ArrayList<Patient>();

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
		// file, maybe. I do not know.
	}

	public static Patient linSearch(ArrayList<Patient> p, int searchFor){
		int sizeP = p.size();

		for( int i = 0; i < sizeP; i++ ){
			if(p.get(i).getID() == searchFor){
				return p.get(i);
			}
		}


		return null;
	}


	public static ArrayList<Patient> sortPatients(ArrayList<Patient> p){
		int n = p.size();
		getAllIDs(p);

		for(int i = 0; i < n; i++){
			for(int x = 1; x < n-i; x++){
				if(allIDs[x-1] > allIDs[x]){
					swap(x, allIDs);
				}
			}
		}

		for(int z: allIDs){
			sortedList.add(linSearch(p, z));
		}

		return sortedList;
	}

	private static void swap(int index, int[] theArray){
		int replace = theArray[index - 1];
		theArray[index - 1] = theArray[index];
		theArray[index] = replace;
	}

	public static void getAllIDs(ArrayList<Patient> p){
		allIDs = new int[p.size()];

		for(int x = 0; x < p.size(); x++){
			int anID = p.get(x).getID();
			allIDs[x] = anID;
		}
	}

	public static String[] splitPatient(String input){
		int startIndex = input.indexOf(",");
		int finalIndex = input.lastIndexOf(",");
		int index = startIndex;

		int start = -1;
		int count = 2; // accounts for the first and last word

		String word;

		// find size of the patients
		while(index < finalIndex){
			index = input.indexOf(",", index + 1);
			count++;
			System.out.println(count);
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
