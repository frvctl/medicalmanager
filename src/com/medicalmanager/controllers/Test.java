package com.medicalmanager.controllers;

import java.io.IOException;

import com.medicalmanager.models.Patient;
import com.medicalmanager.views.PatientView;

public class Test {
	public Test() throws IOException{
		String[] firstNames = {"Ben", "Bob", "Andrew", "Kevin", "Joe", "Michael", "Norah", "Andrea", "Christine", "Haley", "Kelsey", "Sarah"}; //11
		String[] middleNames = {"Ryan", "Middle", "Notsure", "What", "This", "Should", "Be", "Its", "Just", "Test", "Output"}; //11
		String[] lastNames = {"Kwok", "Vest", "Ursini", "Cool", "Tapir", "Tamir", "Derp", "Merp", "Flerp", "Quirk", "Lerp"}; //11
		
		for(int z = 0; z < 10000; z++){
			int rand = (int) (Math.random() * 11);
			double randPressure = Math.random() * 200 + 50;
			double randBMI = Math.random() * 30;
			int randAge = (int)(Math.random() * 100);
			double randMAP = Math.random() * 30;
			double randHeight = Math.random() * 80 + 20;
			double randWeight = Math.random() * 300 + 80;
			
			Patient readPatient = new Patient()
				.setID(z)
				.setFirstName(firstNames[rand])
				.setMiddleName(middleNames[rand])
				.setLastName(lastNames[rand])
				.setDOB("09/05/94")
				.setAddress("5216 Clinton Rd.")
				.setEmailAddress("examples@example.com")
				.setHomePhone("1-703-354-8839")
				.setCellPhone("1-540-247-1023")
				.setAdditionalPatientInformation("This patient is a patient  this is filler data. This patient is a patient  this is filler data. This patient is a patient  this is filler data. This patient is a patient  this is filler data. This patient is a patient  this is filler data. This patient is a patient  this is filler data. This patient is a patient  this is filler data. This patient is a patient  this is filler data. This patient is a patient  this is filler data. This patient is a patient  this is filler data. This patient is a patient  this is filler data. This patient is a patient  this is filler data. ")
				.setMedicalConditions("Diabetes Type 2")
				.setTobaccoUsage("None")
				.setAlcoholConsumption("Minimal")
				.setCurrentMedications("None")
				.setAdditionalMedicalInformation("This is a patient who happens to be a patient with no medical conditions  this is filler data. This is a patient who happens to be a patient with no medical conditions  this is filler data. This is a patient who happens to be a patient with no medical conditions  this is filler data. This is a patient who happens to be a patient with no medical conditions  this is filler data. This is a patient who happens to be a patient with no medical conditions  this is filler data. This is a patient who happens to be a patient with no medical conditions  this is filler data. This is a patient who happens to be a patient with no medical conditions  this is filler data. This is a patient who happens to be a patient with no medical conditions  this is filler data. ")
				.setPatientAnalysis("This is a patient analysis.... doodaaa This is a patient analysis.... doodaaa This is a patient analysis.... doodaaa This is a patient analysis.... doodaaa This is a patient analysis.... doodaaa This is a patient analysis.... doodaaa This is a patient analysis.... doodaaa This is a patient analysis.... doodaaa This is a patient analysis.... doodaaa This is a patient analysis.... doodaaa ")
				.setAge(randAge)
				.setHeight(randHeight)
				.setWeight(randWeight)
				.setSystolicBloodPressure(randPressure)
				.setDiastolicBloodPressure(randPressure)
				.setBMI(randBMI)
				.setMAP(randMAP);
			
			
			//PatientView.patientArray.add(readPatient);
			Database.writeToFile(Patient.stringify(readPatient), true);
			PatientView.updateList(readPatient);
			System.out.println("DERP?");
		}
	}
}
