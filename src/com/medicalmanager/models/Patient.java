package com.medicalmanager.models;

public class Patient {
	
	// Basic Patient Information
	private String name;
	private String DOB;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	
	// Medical Information
	private String insuranceCompany;
	private String medicalConditions;
	private String currentMedications;
	private String additionalComments;
	
	// Numerical Values
	private int ID;
	private int age;
	private double height;
	private double weight;
	
	// Calculated
	private double BMI;
	private double averageSystolicBP;
	 
    public Patient() { }
   
    public static Patient create() {
        return new Patient();
    }
    
    public Patient addName(String name) {
    	this.name = name;
        return this;
    }
    
    public Patient addAge(int age) {
    	this.age = age;
        return this;
    }
    
    public Patient addDOB(String DOB) {
    	this.DOB = DOB;
        return this;
    }
    
    public Patient addHeight(double height) {
    	this.height = height;
        return this;
    }
    
    public Patient addWeight(double weight) {
    	this.weight = weight;
        return this;
    }
    
    public Patient addInsuranceCompany(String insuranceCompany) {
    	this.insuranceCompany = insuranceCompany;
        return this;
    }
    
    public Patient addCalculatedBMI(double calculatedBMI) {
    	this.BMI = calculatedBMI;
        return this;
    }
    
    public Patient addMedicalConditions(String medicalConditions) {
    	this.medicalConditions = medicalConditions;
        return this;
    }
    
    public Patient addCurrentMedications(String currentMedications) {
    	this.currentMedications = currentMedications;
        return this;
    }
    
    public Patient addAddress(String address) {
    	this.address = address;
        return this;
    }
    
    public Patient addPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
        return this;
    }
    
    public Patient addEmailAddress(String emailAddress) {
    	this.emailAddress = emailAddress;
        return this;
    }
    
    public Patient addAdditionalComments(String additionalComments) {
    	this.additionalComments = additionalComments;
        return this;
    }
    
    public String getName(){
    	return this.name;
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
    
    public String getDOB(){
    	return this.DOB;
    }
    
    public String getAddress(){
    	return this.address;
    }
    
    public String getPhoneNumber(){
    	return this.phoneNumber;
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
    
    public double getCalculatedBMI(){
    	return this.BMI;
    }
    
    public String getAddictionalComments(){
    	return this.additionalComments;
    }
    
    public String getInsuranceCompany(){
    	return this.insuranceCompany;
    }

}