package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_application")
public class ApplicationEntity {
	@Column( name = "userId", length= 6)
	@Id
	private String userId;
	
	@Column( name = "constituency", length= 20)
	private  String constituency;
	
	@Column( name = "passedstatus", length= 2)
	private int passedStatus; 
	
	@Column( name = "approvedstatus", length= 2)
	private int approvedStatus;
	
	@Column( name = "voterid", length= 8)
	private String voterId;
	
	public ApplicationEntity() {
		super();
	}
	
	public ApplicationEntity(String constituency, int approvedStatus, String voterId) {
		super();
		this.constituency = constituency;
		this.approvedStatus = approvedStatus;
		this.voterId = voterId;
	}

	public ApplicationEntity(String userId, String constituency, int passedStatus, int approvedStatus, String voterId) {
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

