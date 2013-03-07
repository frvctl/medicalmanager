package com.medicalmanager.controllers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.io.IOException;
import java.util.ArrayList;

import com.medicalmanager.models.Patient;

/**
 * Supports writing patients out to a file of your choosing.
 * 
 * @school: Annandale High School
 * @IDE: Eclipse
 * @date: 3/6/2013
 * @author Ben Vest
 *
 */
public class Output {
	
	public Output(){}
	
	/**
	 * Sends the array list provided to the file name provided in a human readable format.
	 * 
	 * @param fileName The file that the patient will be printed out to
	 * @param pRay The ArrayList used to make the file
	 * @throws IOException 
	 */
	public static void sendToHumanReadableFile(String fileName, ArrayList<Patient> pRay) throws IOException{
		Database.setFile(fileName);
		String newLine = "\r\n";
		for(Patient p: pRay){
			Database.writeToFile("#***========== Patient " + p.getID() + " =========***" + newLine, true);
			Database.writeToFile("	Name: " + p.getFullName() + newLine, true);
			Database.writeToFile("	Age: " + p.getAge() + newLine, true);
			Database.writeToFile("	Name: " + p.getFirstName() + newLine, true);
			Database.writeToFile("	Height: " + p.getHeight() + newLine, true);
			Database.writeToFile("	Weight: " + p.getWeight() + newLine, true);
			Database.writeToFile("	Date of Birth: " + p.getDOB() + newLine, true);
			Database.writeToFile("	Body Mass Index: " + p.getBMI() + newLine, true);
			Database.writeToFile("	Address: " + p.getAddress() + newLine, true);
			Database.writeToFile("	Home Phone: " + p.getHomePhoneNumber() + newLine, true);
			Database.writeToFile("	Cell Phone: " + p.getCellPhoneNumber() + newLine, true);
			Database.writeToFile("	Current Medications: " + p.getCurrentMedications() + newLine, true);
			Database.writeToFile("	Additional Medical Information: " + p.getAdditionalMedicalInformation() + newLine, true);
		}
	}
}



