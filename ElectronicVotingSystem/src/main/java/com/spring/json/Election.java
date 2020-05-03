package com.spring.json;

import java.time.LocalDate;

public class Election {

	private String electionid;
	private String name;
	private LocalDate electionDate;
	private String district;
	private String constituency;
	private LocalDate countingDate;

	public Election() {
		super();
	}

	public Election(String electionid, String name, LocalDate electionDate, String district, String constituency,
			LocalDate countingDate) {
		super();
		this.electionid = electionid;
		this.name = name;
		this.electionDate = electionDate;
		this.district = district;
		this.constituency = constituency;
		this.countingDate = countingDate;
	}

	public String getElectionid() {
		return electionid;
	}

	public void setElectionid(String electionid) {
		this.electionid = electionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getElectionDate() {
		return electionDate;
	}

	public void setElectionDate(LocalDate electionDate) {
		this.electionDate = electionDate;
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

	public LocalDate getCountingDate() {
		return countingDate;
	}

	public void setCountingDate(LocalDate countingDate) {
		this.countingDate = countingDate;
	}

}
