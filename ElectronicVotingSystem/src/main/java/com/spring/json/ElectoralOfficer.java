package com.spring.json;

public class ElectoralOfficer {
	private String electoralofficerId;
	private String constituency;
	public ElectoralOfficer(String electoralofficerId, String constituency) {
		super();
		this.electoralofficerId = electoralofficerId;
		this.constituency = constituency;
	}
	public String getElectoralofficerId() {
		return electoralofficerId;
	}
	public void setElectoralofficerId(String electoralofficerId) {
		this.electoralofficerId = electoralofficerId;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	@Override
	public String toString() {
		return "ElectoralOfficer [electoralofficerId=" + electoralofficerId + ", constituency=" + constituency + "]";
	}
	
	
}
