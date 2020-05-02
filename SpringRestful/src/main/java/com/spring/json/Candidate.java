package com.spring.json;

import java.time.LocalDate;

public class Candidate {
	private String candidateId;
	private String name;
	private String electionId;
	private String partyId;
	private String district;
	private String constituency;
	private LocalDate dateOfBirth;
	private String mobileNo;
	private String address;
	private String emailId;
	
	
	public Candidate() {
		super();
	}


	public Candidate(String candidateId, String name, String electionId, String partyId, String district,
			String constituency, LocalDate dateOfBirth, String mobileNo, String address, String emailId) {
		super();
		this.candidateId = candidateId;
		this.name = name;
		this.electionId = electionId;
		this.partyId = partyId;
		this.district = district;
		this.constituency = constituency;
		this.dateOfBirth = dateOfBirth;
		this.mobileNo = mobileNo;
		this.address = address;
		this.emailId = emailId;
	}


	public String getCandidateId() {
		return candidateId;
	}


	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getElectionId() {
		return electionId;
	}


	public void setElectionId(String electionId) {
		this.electionId = electionId;
	}


	public String getPartyId() {
		return partyId;
	}


	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getConstituency() {
		return constituency;
	}


	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
