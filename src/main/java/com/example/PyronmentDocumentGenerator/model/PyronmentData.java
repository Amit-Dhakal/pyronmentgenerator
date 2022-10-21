package com.example.PyronmentDocumentGenerator.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pyronmentdata")
public class PyronmentData {
	
	@Id
	private String id;
	
	private String title;
	private String clientFullName;
	private String clientFirstandSecondName;
	private String familyName;
	private String completionDate;
	private String adviserName;
	private String address;
	
	private String phone;
	private String email ;	
	private String website;	
	private String dateofbirth;
	private String gender;
	private String maritalstatus;
	private String passportnumber;
	

	
	public String getPassportnumber() {
		return passportnumber;
	}
	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}
	public String getClientFirstandSecondName() {
		return clientFirstandSecondName;
	}
	public void setClientFirstandSecondName(String clientFirstandSecondName) {
		this.clientFirstandSecondName = clientFirstandSecondName;
	}
	//contact detials	
	private String residentialAddressone;
	private String residentialAddresstwo;
	private String correspondenceAddressone;
	private String correspondenceAddresstwo;
	private String country;
	private String resdentialStatus;
	private String secondaryEmail;
	
	
	
	//Employment Details
	private String employmentStatus;
	private String occupation;
	private String employer;
	private String educationLevel;
	private String careerChange;
	
	
	
	
	//PERSONAL HEALTH QUESTIONS
	
	
	private String healthRatings;
	private String smoking;
	private String physicalDisabilityorHealthcondition;
	

	
	//CHILDREN, FAMILY AND DEPENDANTS' INFORMATION
	
	
	
	// TAX & RESIDENT STATUS
	private String residentStatus;
	private String residentSince;
	private String residentType;
	
	
	
	//SOURCE OF WEALTH & INVESTOR CATEGORY (ANTI-MONEY LAUNDERING QUESTIONS)
	

	private String wealthsource;
	private String investorCategory;
	private String politicalexposedperson;

 
	
	// ESTATE PLANNING	
	
	
	
	
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getClientFullName() {
		return clientFullName;
	}
	public void setClientFullName(String clientFullName) {
		this.clientFullName = clientFullName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}
	public String getAdviserName() {
		return adviserName;
	}
	public void setAdviserName(String adviserName) {
		this.adviserName = adviserName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public String getResidentialAddressone() {
		return residentialAddressone;
	}
	public void setResidentialAddressone(String residentialAddressone) {
		this.residentialAddressone = residentialAddressone;
	}
	public String getResidentialAddresstwo() {
		return residentialAddresstwo;
	}
	public void setResidentialAddresstwo(String residentialAddresstwo) {
		this.residentialAddresstwo = residentialAddresstwo;
	}
	public String getCorrespondenceAddressone() {
		return correspondenceAddressone;
	}
	public void setCorrespondenceAddressone(String correspondenceAddressone) {
		this.correspondenceAddressone = correspondenceAddressone;
	}
	public String getCorrespondenceAddresstwo() {
		return correspondenceAddresstwo;
	}
	public void setCorrespondenceAddresstwo(String correspondenceAddresstwo) {
		this.correspondenceAddresstwo = correspondenceAddresstwo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getResdentialStatus() {
		return resdentialStatus;
	}
	public void setResdentialStatus(String resdentialStatus) {
		this.resdentialStatus = resdentialStatus;
	}
	public String getSecondaryEmail() {
		return secondaryEmail;
	}
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public String getEducationLevel() {
		return educationLevel;
	}
	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}
	public String getCareerChange() {
		return careerChange;
	}
	public void setCareerChange(String careerChange) {
		this.careerChange = careerChange;
	}
	
	
	
	
	
	
	
	
	

}
