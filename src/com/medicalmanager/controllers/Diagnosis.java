package com.medicalmanager.controllers;

/**
 * Diagnosis methods for diagnosing a patient.
 * 
 * @school: Annandale High School
 * @IDE: Eclipse
 * @date: 3/6/2013
 * @author Ben Vest
 *
 */
public class Diagnosis {
	
	/**
	 * Calculates a patients Body Mass Index
	 * 
	 * @param height The height of the patient in inches
	 * @param weight The weight of the patient in lbs
	 * @return The BMI calculated using the given height and weight
	 */
	public static double calculateBMI(double height, double weight){
		return ((weight)/(Math.pow(height, 2))) * 703;
	}
	
	/**
	 * Calculates a patients Mean Arterial Blood Pressure
	 * 
	 * @param diastolic The patients diastolic blood pressure
	 * @param systolic The Patients systolic blood pressure
	 * @return The calculated MAP
	 */
	public static double calculateMAP(double diastolic, double systolic) {
		return (((2*diastolic) + systolic)/3);
	}
	
	/**
	 * Analyzes the patients BMI and provides the user
	 * information about how the BMI was calculated.
	 * 
	 * @param bmi The BMI of the patient
	 * @param height The Height of the Patient
	 * @param weight The Weight of the Patient
	 * @return A formatted string with a detailed analysis of 
	 * a patients BMI situation.
	 */
	public static String analyizeBMI(double bmi, double height, double weight){
		String bmiExplanation = "BMI is calculated using the formula (weight / height^2) * 703" +
								" per the U.S. Department of Health and Human Services's advice. " +
								"Based on the data entered of a weight of %f and height of %f the" +
								" patient is %s";
		return String.format(bmiExplanation, height, weight, bmiDiagnosis(bmi));
	}
	
	
	/**
	 * Assigns a label to the MAP of a patient
	 * 
	 * @param map The patients MAP
	 * @return The MAP Classification
	 */
	public static String mapDiagnosis(double map){
		String MAPDiagnosis = null;
		
		if (map > 70 && map < 110){
			MAPDiagnosis = "Normal";
		} else if (map > 110) {
			MAPDiagnosis = "Too High";
		} else {
			MAPDiagnosis = "Too Low";
		}
		
		return MAPDiagnosis;
	}
	
	/**
	 * Assigns a label to the BMI of the patient
	 * 
	 * @param BMI The Patients BMI
	 * @return The BMI Classification
	 */
	public static String bmiDiagnosis(double BMI){
		String BMIDiagnosis = null;
		
		if(BMI < 18){
			BMIDiagnosis = "Underweight";
		}else if(BMI > 18 && BMI < 24.9){
			BMIDiagnosis = "Normal Weight";
		}else if(BMI > 25 && BMI < 29.9){
			BMIDiagnosis = "Over Weight";
		}else{
			BMIDiagnosis = "Obese";
		}
		return BMIDiagnosis;
	}

}
