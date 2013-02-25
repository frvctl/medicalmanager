package com.medicalmanager.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.medicalmanager.models.Patient;

public class Output {
	
	public Output(){}
	
	public static void sendToHumanReadableFile(String fileName, ArrayList<Patient> pRay) throws IOException{
		Database.setFile(fileName);
		String newLine = "\r\n";
		for(Patient p: pRay){
			Database.writeToFile("#***========== Patient " + p.getID() + " =========***" + newLine, true);
			Database.writeToFile("#*** Name: " + p.getFullName() + newLine, true);
			Database.writeToFile("#*** Age: " + p.getAge() + newLine, true);
			Database.writeToFile("#*** Name: " + p.getFirstName() + newLine, true);
			Database.writeToFile("#*** Height: " + p.getHeight() + newLine, true);
			Database.writeToFile("#*** Weight: " + p.getWeight() + newLine, true);
			Database.writeToFile("#***==============================***" + newLine, true);
		}
	}
}



//Database.writeToFile("Date of Birth", p.getDOB())
//Database.writeToFile("Body Mass Index", p.getBMI())
//Database.writeToFile("Address", p.getAddress())
//Database.writeToFile("Home Phone", p.getHomePhoneNumber())
//Database.writeToFile("Cell Phone", p.getCellPhoneNumber())
//Database.writeToFile("Current Medications", p.getCurrentMedications())
//Database.writeToFile("Additional Medical Information", p.getAdditionalMedicalInformation()));