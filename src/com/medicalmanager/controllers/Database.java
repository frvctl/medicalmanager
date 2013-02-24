package com.medicalmanager.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.medicalmanager.models.Patient;
import com.medicalmanager.views.PatientView;

public class Database {
	public static int[] allIDs;
	public static ArrayList<Patient> sortedList = new ArrayList<Patient>();
	public static FileWriter fw;
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
		Database.writeFile = new File(Database.writeDirectory.getPath() + "/" + fileName);
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
		
		System.out.println(Database.getFile());
		
		if (!Database.getFile().exists()) {
			try {
				Database.getFile().createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}

	public static void writeToFile(String input, boolean append) throws IOException{
		try {
			fw = new FileWriter(Database.getFile(), append);
			fw.write(input);
			fw.flush();
			fw.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				fw.close();
			}
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
	
	/*
	 * Sample File CSV 
	 * 0,                           0  -- ID 
	 * first,                       1  -- first name
	 * middle,                      2  -- middle name
	 * last,                        3  -- last name
	 * dateofbirth,                 4  -- date of birth
	 * home,                        5  -- address
	 * email,                       6  -- email
	 * phone,                       7  -- home phone
	 * cell,                        8  -- cell phone
	 * info,                        9  -- additional information
	 * conditions,                  10 -- current medical conditions
	 * Yes - Several Packs a day,   11 -- tobaco usage
	 * Yes - Very heavy drinker ,   12 -- alcohol consumption
	 * meds,                        13 -- current medications
	 * adasdfsdfsdfa ,              14 -- additionalmedical information
	 * aditionalMedical,            15 -- patient analysis
	 * 189.0,                       16 -- Age
	 * 890.0,                       17 -- Height
	 * 908.0,                       18 -- Weight
	 * 0.0,                         19 -- Systolic
	 * 0.0,                         20 -- Diastolic
	 * 0.8058628960989774,          21 -- BMI
	 * 0.0,                         22 -- MAP
	 * Too Low,                     23 -- MAP Analysis
	 * Underweight                  24 -- BMI Analysis
	 * 
	 */
	
	public static void readAllPatientsFromFile() throws IOException{
		try {
			BufferedReader br = new BufferedReader(new FileReader(writeFile));
			String line = null;
			String[] stringray = new String[24];
			int x = countLines();
			while ((line = br.readLine()) != null) {
				stringray = splitPatient(line);
				System.out.println(line);
				if(stringray != null) {
					Patient readPatient = new Patient()
						.setID(Integer.parseInt(stringray[0]))
						.setFirstName(stringray[1])
						.setMiddleName(stringray[2])
						.setLastName(stringray[3])
						.setDOB(stringray[4])
						.setAddress(stringray[5])
						.setEmailAddress(stringray[6])
						.setHomePhone(stringray[7])
						.setCellPhone(stringray[8])
						.setAdditionalPatientInformation(stringray[9])
						.setMedicalConditions(stringray[10])
						.setTobaccoUsage(stringray[11])
						.setAlcoholConsumption(stringray[12])
						.setCurrentMedications(stringray[13])
						.setAdditionalMedicalInformation(stringray[14])
						.setPatientAnalysis(stringray[15])
						.setAge(Double.parseDouble(stringray[16]))
						.setHeight(Double.parseDouble(stringray[17]))
						.setWeight(Double.parseDouble(stringray[18]))
						.setSystolicBloodPressure(Double.parseDouble(stringray[19]))
						.setDiastolicBloodPressure(Double.parseDouble(stringray[20]))
						.setBMI(Double.parseDouble(stringray[21]))
						.setMAP(Double.parseDouble(stringray[22]));
					
				
					PatientView.updateList(readPatient);
					x--;
				}
			}
		}catch (Exception e) {
		    e.printStackTrace();
		}
	}

	public static void writeAllPatientsToFile() throws IOException{
		boolean append = false;
		for(Patient p: PatientView.patientArray){
			writeToFile(Patient.stringify(p), append);
			append = true;
		}
	}
	
	public static class CompareName implements Comparator<Patient> {
		  @Override
		  public int compare(Patient p1, Patient p2) {
		    String rank1 = p1.getFirstName();
		    String rank2 = p2.getFirstName();
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
			toFind.setID(Integer.parseInt(options[0]));
			index = Collections.binarySearch(listToSort, toFind, new CompareID());
		} catch (NumberFormatException se){
			toFind.setFirstName(options[0]);
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
	
	public static void updatePatient(Patient p, String[] data, ArrayList<Patient> pRay){
		int editIndex = pRay.indexOf(p);
		p.setFirstName(data[0]);
		PatientView.updateListAfterPatientEdit(editIndex, p);
		try {
			Database.writeAllPatientsToFile();
		} catch (IOException e) {
			e.printStackTrace();
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
