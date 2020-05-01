package com.spring.service;


import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.json.LoginResponse;
import com.spring.json.UserCredentials;

public interface AdminService {

	Object addElection(ElectionEntity election, String sessionId);

	Object getElectionDetails(String sessionId);

	LoginResponse adminLogin(UserCredentials userCredentials);

	LoginResponse adminLogout(String sessionId);
	
	Object addParty(PartyEntity party, String sessionId);
	
	Object getPartyDetails(String sessionId);

}
