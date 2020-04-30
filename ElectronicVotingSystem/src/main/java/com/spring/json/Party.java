package com.spring.json;

public class Party {
	private String partyid;
	private String name;
	private String leader;
	private String symbol;
	public String getPartyid() {
		return partyid;
	}
	public void setPartyid(String partyid) {
		this.partyid = partyid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Party(String partyid, String name, String leader, String symbol) {
		super();
		this.partyid = partyid;
		this.name = name;
		this.leader = leader;
		this.symbol = symbol;
	}
	public Party(String name, String leader, String symbol) {
		super();
		this.name = name;
		this.leader = leader;
		this.symbol = symbol;
	}
	@Override
	public String toString() {
		return "Party [partyid=" + partyid + ", name=" + name + ", leader=" + leader + ", symbol=" + symbol + "]";
	}
	
	

}
