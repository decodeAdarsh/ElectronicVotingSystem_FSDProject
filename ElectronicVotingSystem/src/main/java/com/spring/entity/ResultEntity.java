package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_election")
public class ResultEntity {
	
	@GeneratedValue
	@Id
	@Column(name="ID")
	private long serialno;
	
	@Column(name = "election_id")
	private String electionid;
	
	@Column(name = "candidate_id")
	private String candidateid;
	
	@Column(name = "vote_count")
	private int voteCount;
	
	@Column(name = "result_status")
	private int resultStatus;
	

	public ResultEntity(String electionid, String candidateid, int voteCount, int resultStatus) {
		super();
		this.electionid = electionid;
		this.candidateid = candidateid;
		this.voteCount = voteCount;
		this.resultStatus = resultStatus;
	}
	
	
	public ResultEntity(long serialno, String electionid, String candidateid, int voteCount, int resultStatus) {
		super();
		this.serialno = serialno;
		this.electionid = electionid;
		this.candidateid = candidateid;
		this.voteCount = voteCount;
		this.resultStatus = resultStatus;
	}


	public long getSerialno() {
		return serialno;
	}
	public void setSerialno(long serialno) {
		this.serialno = serialno;
	}
	public String getElectionid() {
		return electionid;
	}
	public void setElectionid(String electionid) {
		this.electionid = electionid;
	}
	public String getCandidateid() {
		return candidateid;
	}
	public void setCandidateid(String candidateid) {
		this.candidateid = candidateid;
	}
	public int getVotecount() {
		return voteCount;
	}
	public void setVotecount(int voteCount) {
		this.voteCount = voteCount;
	}
	public int getResultstatus() {
		return resultStatus;
	}
	public void setResultstatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}
	@Override
	public String toString() {
		return "Result [serialno=" + serialno + ", electionid=" + electionid + ", candidateid=" + candidateid
				+ ", voteCount=" + voteCount + ", resultStatus=" + resultStatus + "]";
	}

}
