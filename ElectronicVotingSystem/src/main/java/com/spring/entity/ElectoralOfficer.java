package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_eo")
public class ElectoralOfficer {
	@Column(name = "electoralofficerId", length = 6)
	@Id
	private String electoralofficerId;
	@Column(name = "constituency", length = 25)
	private String constituency;
	
	public ElectoralOfficer() {
		super();
	}
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
