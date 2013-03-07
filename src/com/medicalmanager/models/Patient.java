package com.medicalmanager.models;

import com.medicalmanager.controllers.Diagnosis;

/**
 * Patient Object Model, allows patients to be created
 * and data to be assigned to them.
 * 
 * @school: Annandale High School
 * @IDE: Eclipse
 * @date: 3/6/2013
 * @author Ben Vest
 *
 */
public class Patient {
	private int ID;
	
	// Basic Patient Information
	private String firstName;
	private String lastName;
	private String middleName;
	private String race;
	private String gender;
	private String DOB;
	private String address;
	private String emailAddress;
	private String homePhoneNumber;
	private String cellPhoneNumber;
	private String additionalPatientInformation;
	
	// Medical Information
	private double age;
	private double height;
	private double weight;
	private String tobaccoUsage;
	private String alcoholConsumption;
	private String medicalConditions;
	private String currentMedications;
	private String additionalMedicalInformation;
	
	// Calculated
	private double BMI;
	private double MAP;
	private double systolicBloodPressure;
	private double diastolicBloodPressure;
	private String patientAnalysis; 
	
    public Patient() { }
   
	public Patient setID(int ID) {
		this.ID = ID;
		return this;
	}
    
    public Patient setFirstName(String name) {
    	this.firstName = name;
        return this;
    }
    
    public Patient setMiddleName(String name){
    	this.middleName = name;
    	return this;
    }
    
    public Patient setLastName(String name){
    	this.lastName = name;
    	return this;
    }
    
    public Patient setGender(String gender){
    	this.gender = gender;
    	return this;
    }
    
    public Patient setRace(String race){
    	this.race = race;
    	return this;
    }
    
    public Patient setAge(double d) {
    	this.age = d;
        return this;
    }
    
    public Patient setDOB(String DOB) {
    	this.DOB = DOB;
        return this;
    }
    
    public Patient setHeight(double height) {
    	this.height = height;
        return this;
    }
    
    public Patient setWeight(double weight) {
    	this.weight = weight;
        return this;
    }
    
    public Patient setCalculatedBMI() {
    	this.BMI = Diagnosis.calculateBMI(this.height, this.weight);
        return this;
    }
    
    public Patient setCalculatedMAP(){
    	this.MAP = Diagnosis.calculateMAP(this.diastolicBloodPressure, this.systolicBloodPressure);
    	return this;
    }
    
    public Patient setMedicalConditions(String medicalConditions) {
    	this.medicalConditions = medicalConditions;
        return this;
    }
    
    public Patient setCurrentMedications(String currentMedications) {
    	this.currentMedications = currentMedications;
        return this;
    }
    
    public Patient setAddress(String address) {
    	this.address = address;
        return this;
    }
    
    public Patient setHomePhone(String phoneNumber) {
    	this.homePhoneNumber = phoneNumber;
        return this;
    }
    
    public Patient setCellPhone(String phoneNumber){
    	this.cellPhoneNumber = phoneNumber;
    	return this;
    }
    
    public Patient setEmailAddress(String emailAddress) {
    	this.emailAddress = emailAddress;
        return this;
    }
    
    public Patient setAlcoholConsumption(String consumption){
    	this.alcoholConsumption = consumption;
    	return this;
    }
    
    public Patient setTobaccoUsage(String usage){
    	this.tobaccoUsage = usage;
    	return this;
    }
    
    public Patient setSystolicBloodPressure(double systolic){
    	this.systolicBloodPressure = systolic;
    	return this;
    }
    
    public Patient setDiastolicBloodPressure(double diastolic){
    	this.diastolicBloodPressure = diastolic;
    	return this;
    }
    
    public Patient setPatientAnalysis(String analysis){
    	this.patientAnalysis = analysis;
    	return this;
    }
    
    public Patient setAdditionalMedicalInformation(String info){
    	this.additionalMedicalInformation = info;
    	return this;
    }
    
    public Patient setAdditionalPatientInformation(String info) {
    	this.additionalPatientInformation = info;
        return this;
    }
    
    public Patient setBMI(double BMI){
    	this.BMI = BMI;
    	return this;
    }
    
    public Patient setMAP(double MAP){
    	this.MAP = MAP;
    	return this;
    }
    
    /*
     * --------------------------------------------------
     * Getters 
     * --------------------------------------------------
     */
    
    public int getID(){
    	return this.ID;
    }
    
    public String getFullName(){
    	return this.firstName + " " + this.middleName + " " + this.lastName;
    }
    
    public String getFirstName(){
    	return this.firstName;
    }
    
    public String getMiddleName(){
    	return this.middleName;
    }
    
    public String getLastName(){
    	return this.lastName;
    }
    
    public double getAge(){
    	return this.age;
    }
    
    public double getHeight(){
    	return this.height;
    }
     
    public double getWeight(){
    	return this.weight;
    }
    
    public double getSystolicBloodPressure(){
    	return this.systolicBloodPressure;
    }
    
    public double getDiastolicBloodPressure(){
    	return this.diastolicBloodPressure;
    }
    
    public String getDOB(){
    	return this.DOB;
    }
    
    public String getAddress(){
    	return this.address;
    }
    
    public String getHomePhoneNumber(){
    	return this.homePhoneNumber;
    }
    
    public String getCellPhoneNumber(){
    	return this.cellPhoneNumber;
    }
    
    public String getEmailAddress(){
    	return this.emailAddress;
    }
    
    public String getCurrentMedications(){
    	return this.currentMedications;
    }
    
    public String getMedicalConditions(){
    	return this.medicalConditions;
    }
    
    public String getTobaccoUsage(){
    	return this.tobaccoUsage;
    }
    
    public String getAlcoholConsumption(){
    	return this.alcoholConsumption;
    }
    
    public double getBMI(){
    	return this.BMI;
    }
    
    public String getBMIDiagnosis(){
    	return Diagnosis.bmiDiagnosis(this.BMI);
    }
    
    public double getMAP(){
    	return this.MAP;
    }
    
    public String getRace(){
    	return this.race;
    }
    
    public String getGender(){
    	return this.gender;
    }
    
    public String getMAPDiagnosis(){
    	return Diagnosis.mapDiagnosis(this.MAP);
    }
    
    public String getAdditionalPatientInformation(){
    	return this.additionalPatientInformation;
    }
    
    public String getAdditionalMedicalInformation(){
    	return this.additionalMedicalInformation;
    }
    
    public String getPatientAnalysis(){
    	return this.patientAnalysis;
    }
    
    /**
     * Method that allows a patient to be split and stored in the text file
     * essentially csvifies the patients data
     * 
     * @param patient The patient being stringified
     * @return A string version of the patient passed in
     */
    public static String stringify (Patient patient){
    	String patientString = "";
    	String comma = ", ";
    			
    	patientString = patient.getID() 
    					+ comma + patient.getFirstName()
    					+ comma + patient.getMiddleName()
    					+ comma + patient.getLastName()
    					+ comma + patient.getDOB() 
    					+ comma + patient.getAddress()
    					+ comma + patient.getEmailAddress()
    					+ comma + patient.getHomePhoneNumber()
    					+ comma + patient.getCellPhoneNumber()
    					+ comma + patient.getAdditionalPatientInformation()
    					+ comma + patient.getMedicalConditions()
    					+ comma + patient.getTobaccoUsage()
    					+ comma + patient.getAlcoholConsumption()
    					+ comma + patient.getCurrentMedications()
    					+ comma + patient.getAdditionalMedicalInformation()
    					+ comma + patient.getPatientAnalysis()
    					+ comma + patient.getAge()
    					+ comma + patient.getHeight()
    					+ comma + patient.getWeight()
    					+ comma + patient.getSystolicBloodPressure()
    					+ comma + patient.getDiastolicBloodPressure()
    					+ comma + patient.getBMI()
    					+ comma + patient.getMAP()
    					+ comma + patient.getMAPDiagnosis()
    					+ comma + patient.getBMIDiagnosis()
    					+ "\r\n";
    	
		return patientString;
    }
}
