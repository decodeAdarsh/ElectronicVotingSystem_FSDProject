package com.spring.service;

import java.util.List;

import com.spring.entity.ElectionEntity;
import com.spring.json.LoginResponse;
import com.spring.json.UserCredentials;

public interface AdminService {

	void addElection(ElectionEntity election);

	List<ElectionEntity> getElectionDetails();

	LoginResponse adminLogin(UserCredentials userCredentials);

	LoginResponse adminLogout(String sessionId);

}
