package com.spring.json;

public class Result {
	private long serialno;
	private String electionId;
	private String candidateId;
	private int voteCount;
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
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public int getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}
	public Result() {
		super();
	}
	public Result(long serialno, String electionId, String candidateId, int voteCount, int resultStatus) {
		super();
		this.serialno = serialno;
		this.electionId = electionId;
		this.candidateId = candidateId;
		this.voteCount = voteCount;
		this.resultStatus = resultStatus;
	}
	public Result(String electionId, String candidateId, int voteCount, int resultStatus) {
		super();
		this.electionId = electionId;
		this.candidateId = candidateId;
		this.voteCount = voteCount;
		this.resultStatus = resultStatus;
	}
	@Override
	public String toString() {
		return "Result [serialno=" + serialno + ", electionId=" + electionId + ", candidateId=" + candidateId
				+ ", voteCount=" + voteCount + ", resultStatus=" + resultStatus + "]";
	}

}
