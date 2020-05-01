package com.spring.json;

public class Result {
	private long serialno;
	private String electionid;
	private String candidateid;
	private int voteCount;
	private int resultStatus;
	
	//
	
	public Result() {
		super();
	}


	public Result(String electionid, String candidateid, int voteCount, int resultStatus) {
		super();
		this.electionid = electionid;
		this.candidateid = candidateid;
		this.voteCount = voteCount;
		this.resultStatus = resultStatus;
	}
	
	
	public Result(long serialno, String electionid, String candidateid, int voteCount, int resultStatus) {
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
