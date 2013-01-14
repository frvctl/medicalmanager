package com.medicalmanager.helpers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.medicalmanager.models.Patient;
import com.medicalmanager.views.PatientView;

public class DataHelper {
	public static int[] allIDs;
	public static ArrayList<Patient> sortedList = new ArrayList<Patient>();
	public static FileOutputStream fop;
	public static PrintWriter out;
	public static final String FILE_LOCATION = System.getProperty("user.dir") + "/lib/test.txt";

	static File file = new File(FILE_LOCATION);

	public static void writeToFile(String input, String filename) throws IOException{
		if(filename == null){
			filename = "test.txt";
		}
		try {
			file = new File(System.getProperty("user.dir") + "/lib/" + filename);
			fop = new FileOutputStream(file, true);
			out = new PrintWriter(fop, true);
			
			if (!file.exists()) {
				file.createNewFile();
			}
						
			out.write(input);
			out.flush();
			out.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}	
	
	public static void printAllToFile() throws IOException{
		for(Patient p: PatientView.patientArray){
			writeToFile(p.getName(), "blah.txt");
		}
	}
	
	// Reads the file and counts the lines
	// This is used for PatientID among other things
	public static int count() throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + "/lib/test.txt"));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n')
	                    ++count;
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}

	public static void readAllPatients() throws IOException{
		try {
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/lib/test.txt"));
			String line = null;
			String[] stringray = new String[20];
			while ((line = br.readLine()) != null) {
				stringray = splitPatient(line);
				System.out.println(line);
				Patient readPatient = new Patient()
					.addName(stringray[1])
					.addAge(18)
					.addDOB(null)
					.addAddress(null)
					.addPhoneNumber(null)
					.addInsuranceCompany(null)
					.addMedicalConditions(null)
					.addCurrentMedications(null)
					.addAdditionalComments(null)
					.addID(10)
					.addHeight(10)
					.addWeight(10)
					.addBMI(10,10);
		
				PatientView.updateList(readPatient);
			}
			
			
		}catch (Exception e) {
		    e.printStackTrace();
		}
			
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
		String word2 = null;

		// find size of the patients
		while(index < finalIndex){
			index = input.indexOf(",", index + 1);
			count++;
		}
		
		// create an array that is the size of the number of patient fields
		String[] words = new String[count]; 
		index = startIndex; //reset backs to the start

		// actually split the words
		// return an array of them
		for(int i = 0; i < count; i++){
			if(index == finalIndex && count == 2 && i == 1){
				word = input.substring(start+1, finalIndex);
			}else if(index < finalIndex){
				word = input.substring(start+1, index);
				start = input.indexOf(",", index);
				index = input.indexOf(",", index+1);
			}else{
				word = input.substring(finalIndex + 1);
			}
			words[i] = word.trim();
		}
		return words;
	}

}
