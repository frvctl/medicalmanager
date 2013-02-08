package com.medicalmanager.controllers;

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
import java.util.Collections;
import java.util.Comparator;

import com.medicalmanager.models.Patient;
import com.medicalmanager.views.PatientView;

public class Database {
	public static int[] allIDs;
	public static ArrayList<Patient> sortedList = new ArrayList<Patient>();
	public static FileOutputStream fop;
	public static PrintWriter out;
	private static File writeDirectory;
	private static File writeFile;
	
	public Database() { }
	   
	public static File getWriteDirectory() {
		return writeDirectory;
	}

	public static void setWriteDirectory(String writeDirectory) {
		Database.writeDirectory = new File(writeDirectory);
	}
	
	public static File getFile() {
		return writeFile;
	}

	public static void setFile(String fileName) {
		Database.writeFile = new File(Database.writeDirectory.getPath() + fileName);
	}
	
	public static void prepareFile(){
		try{
			if(Database.getWriteDirectory().mkdir()){
				System.out.println("Directory Created Name: " + getWriteDirectory());
			}else{
				System.out.println("Directory not created - already exists; Name: " + getWriteDirectory());
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		if (!Database.writeFile.exists()) {
			try {
				Database.writeFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
	}

	public static void writeToFile(String input) throws IOException{
		try {
			fop = new FileOutputStream(Database.writeFile, true);
			out = new PrintWriter(fop, true);
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
	
	public static void writeAllPatientsToFile() throws IOException{
		for(Patient p: PatientView.patientArray){
			writeToFile(p.getName());
		}
	}
	
	// Reads the file and counts the lines
	// This is used for PatientID among other things
	public static int countLines() throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(writeFile));
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
	
	public static void readAllPatientsFromFile() throws IOException{
		try {
			BufferedReader br = new BufferedReader(new FileReader(writeFile));
			String line = null;
			String[] stringray = new String[20];
			int x = countLines();
			while ((line = br.readLine()) != null) {
				stringray = splitPatient(line);
				System.out.println(line);
				if(stringray != null) {
					Patient readPatient = new Patient()
						.addName(stringray[1])
						.addAge(Double.parseDouble(stringray[9]))
						.addDOB(null)
						.addAddress(null)
						.addPhoneNumber(null)
						.addInsuranceCompany(null)
						.addMedicalConditions(null)
						.addCurrentMedications(null)
						.addAdditionalComments(null)
						.addID(countLines() - x)
						.addHeight(10)
						.addWeight(Double.parseDouble(stringray[10]))
						.addBMI(10,10);
				
					PatientView.updateList(readPatient);
					x--;
				}
			}
			
			
		}catch (Exception e) {
		    e.printStackTrace();
		}
			
	}
	
	public static class CompareName implements Comparator<Patient> {
		  @Override
		  public int compare(Patient p1, Patient p2) {
		    String rank1 = p1.getName();
		    String rank2 = p2.getName();
		    if (rank1 == null && rank2 == null) {
		      return 0;
		    }

		    if (rank1 == null) {
		      return 1;
		    }
		    if (rank2 == null) {
		      return -1;
		    }

		    return rank1.compareTo(rank2);
		  }    
	}
	
	public static class CompareID implements Comparator<Patient> {
		  @Override
		  public int compare(Patient p1, Patient p2) {
			  int ID1 = p1.getID();
			  int ID2 = p2.getID();
			  return (ID1 > ID2 ? -1 : (ID1 == ID2 ? 0 : 1));
		  }   
	}
	
	private static void swap(int index, int[] theArray){
		int replace = theArray[index - 1];
		theArray[index - 1] = theArray[index];
		theArray[index] = replace;
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
	
	/*
	 * Note: This is a single item lookup type of search, what I need to do from here is take the
	 * index that I find from the search and use it to do another binary search of the names.
	 *  Options are the search meta data
	 *  0 -> Search Query: Name or ID
	 *  1 -> minage-maxage
	 *  2 -> minheight-maxheight
	 *  3 -> minweight-maxweight
	 *  4 -> gender
	 *  5 -> bmiclass
	 *  If any option is not filled in by the user it will come in as "n/a"
	 */
	public static Patient advancedPatientSearch(File file, String[] options){
		ArrayList<Patient> listToSort = PatientView.patientArray;
		sortPatients(listToSort, options[0]);
		int index;
		Patient toFind = new Patient();
		
		try{
			Integer.parseInt(options[0]); // If this passes then it's a number else it goes to the catch block
			toFind.addID(Integer.parseInt(options[0]));
			index = Collections.binarySearch(listToSort, toFind, new CompareID());
		} catch (NumberFormatException se){
			toFind.addName(options[0]);
			index =  Collections.binarySearch(listToSort, toFind, new CompareName());
		}
		
		return PatientView.patientArray.get(index);
	}
	
	public static int search(ArrayList<Patient> p, int searchValue) {
			int left = 0;
			int right = p.size() - 1;
			return binarySearch(p, searchValue, left, right);
	}
 
	private static int binarySearch(ArrayList<Patient> p, int searchValue, int left, int right) {
		if (right < left) {
			return -1;
		}
		
		int mid = (left + right) >>> 1;
		if (searchValue > p.get(mid).getID()) {
			return binarySearch(p, searchValue, mid + 1, right);
		} else if (searchValue < p.get(mid).getID()) {
			return binarySearch(p, searchValue, left, mid - 1);
		} else {
			return mid;
		}               
	} 
	
	/*
	 * options meta data
	 * if its a string use the name if its a number use the id
	 */
	public static void sortPatients(ArrayList<Patient> p, String option){
			try{
				Integer.parseInt(option); // If this passes then it's a number else it goes to the catch block
				Collections.sort(p, new CompareID());
			} catch (NumberFormatException se){
				Collections.sort(p, new CompareName());
			}
	}

	public static void getAllIDs(ArrayList<Patient> p){
		allIDs = new int[p.size()];

		for(int x = 0; x < p.size(); x++){
			int anID = p.get(x).getID();
			allIDs[x] = anID;
		}
	}

	public static String[] splitPatient(String input){
		if(input.length() > 0){
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
		} else {
			return null;
		}
	}
}
