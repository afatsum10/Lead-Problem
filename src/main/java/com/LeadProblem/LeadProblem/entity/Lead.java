package com.LeadProblem.LeadProblem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leads")
public class Lead {

	@Id
	@Column(name = "leadid")
	private Integer leadId;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "middlename")
	private String middleName;

	@Column(name = "gender")
	private String Gender;

	@Column(name = "email")
	private String email;

	@Column(name = "mobilenumber")
	private String mobileNumber;

	@Column(name = "dob")
	private String DOB;

	public Integer getLeadId() {
		return leadId;
	}

	public void setLeadId(Integer leadId) {
		 System.out.println("Setting LeadId: " + leadId);
		this.leadId = leadId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String Gender) {
		 System.out.println("Setting Gender: " + Gender);
		
		this.Gender = Gender;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		
		 System.out.println("Setting Gender: " + DOB);
		this.DOB = DOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

