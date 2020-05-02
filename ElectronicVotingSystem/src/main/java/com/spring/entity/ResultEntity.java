package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_result")
public class ResultEntity {
	
	@GeneratedValue
	@Id
	@Column(name = "serialno")
	private long serialno;
	
	@Column(name = "electionid")
	private String electionId;
	
	@Column(name = "candidateid")
	private String candidateId;
	
	@Column(name = "votecount")
	private int voteCount;
	
	@Column(name = "resultstatus")
	private int resultStatus;
	
	public long getSerialno() {
		return serialno;
	}
	public void setSerialno(long serialno) {
		this.serialno = serialno;
	}
	public String getElectionId() {
		return electionId;
	}
	public void setElectionId(String electionId) {
		this.electionId = electionId;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public long getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public long getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}
	public ResultEntity() {
		super();
	}
	public ResultEntity(long serialno, String electionId, String candidateId, int voteCount, int resultStatus) {
		super();
		this.serialno = serialno;
		this.electionId = electionId;
		this.candidateId = candidateId;
		this.voteCount = voteCount;
		this.resultStatus = resultStatus;
	}
	public ResultEntity(String electionId, String candidateId, int voteCount, int resultStatus) {
		super();
		this.electionId = electionId;
		this.candidateId = candidateId;
		this.voteCount = voteCount;
		this.resultStatus = resultStatus;
	}
	@Override
	public String toString() {
		return "ResultEntity [serialno=" + serialno + ", electionId=" + electionId + ", candidateId=" + candidateId
				+ ", voteCount=" + voteCount + ", resultStatus=" + resultStatus + "]";
	}


}
