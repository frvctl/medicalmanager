package com.medicalmanager.controllers;

public class Diagnosis {
	
	
	public static double calculateBMI(double height, double weight){
		return ((weight)/(Math.pow(height, 2))) * 703;
	}
	
	public static String analyizeBMI(double bmi, double height, double weight){
		String bmiExplanation = "BMI is calculated using the formula (weight / height^2) * 703 per the U.S. Department of Health and Human Services's advice. Based on the data entered of a weight of %f and height of %f the patient is %s";
		
		String blah = String.format(bmiExplanation, height, weight, bmiDiagnosis(bmi));
		
		return blah;
		
	}
	
	public static double calculateMAP(double diastolic, double systolic) {
		return (((2*diastolic) + systolic)/3);
	}
	
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
	
	public static String finalPatientAnalysis(){
		return "blah";
		//TODO
	}
	
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
