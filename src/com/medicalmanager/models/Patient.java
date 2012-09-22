package com.medicalmanager.models;

public class Patient {
	private String name;
	private String age;
	private String DOB;
	private String height;
	private String weight;
	private String insuranceCompany;
	private String calculatedBMI;
	private String medicalConditions;
	private String currentMedications;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	private String additionalComments;
	 
    public Patient() { }
   
    public static Patient create() {
        return new Patient();
    }
    
    public Patient addName(String name) {
    	this.name = name;
        return this;
    }
    
    public Patient addAge(String age) {
    	this.age = age;
        return this;
    }
    
    public Patient addDOB(String DOB) {
    	this.DOB = DOB;
        return this;
    }
    
    public Patient addHeight(String height) {
    	this.height = height;
        return this;
    }
    
    public Patient addWeight(String weight) {
    	this.weight = weight;
        return this;
    }
    
    public Patient addInsuranceCompany(String insuranceCompany) {
    	this.insuranceCompany = insuranceCompany;
        return this;
    }
    
    public Patient addCalculatedBMI(String calculatedBMI) {
    	this.calculatedBMI = calculatedBMI;
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
    
    public String getAge(){
    	return this.age;
    }
    
    public String getHeight(){
    	return this.height;
    }
     
    public String getWeight(){
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
    
    public String getCalculatedBMI(){
    	return this.calculatedBMI;
    }
    
    public String getAddictionalComments(){
    	return this.additionalComments;
    }
    
    public String getInsuranceCompany(){
    	return this.insuranceCompany;
    }

}