package com.spring.json;

public class Application {
	private String userId;
	private  String constituency;
	private int passedStatus; 
	private int approvedStatus;
	private String voterId;
	public Application(String userId, String constituency, int passedStatus, int approvedStatus, String voterId) {
		super();
		this.userId = userId;
		this.constituency = constituency;
		this.passedStatus = passedStatus;
		this.approvedStatus = approvedStatus;
		this.voterId = voterId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public int getPassedStatus() {
		return passedStatus;
	}
	public void setPassedStatus(int passedStatus) {
		this.passedStatus = passedStatus;
	}
	public int getApprovedStatus() {
		return approvedStatus;
	}
	public void setApprovedStatus(int approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
	public String getVoterId() {
		return voterId;
	}
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
	@Override
	public String toString() {
		return "Application [userId=" + userId + ", constituency=" + constituency + ", passedStatus=" + passedStatus
				+ ", approvedStatus=" + approvedStatus + ", voterId=" + voterId + "]";
	}
	
}