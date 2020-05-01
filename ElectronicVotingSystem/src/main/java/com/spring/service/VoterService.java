package com.spring.service;

import java.time.LocalDate;

import com.spring.entity.UserEntity;


public interface VoterService {
	
	
	Object registerVoter(UserEntity user, String userid);
	
	Object statusVoter(String userid);
	
	Object addVoterRequest(UserEntity user, String sessionId);
	
	Object getElectionDateFromAllElections(LocalDate date,String sessionId);
	
	
	
}
