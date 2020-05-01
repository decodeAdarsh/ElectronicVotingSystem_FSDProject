package com.spring.impl;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.entity.UserCredentialsEntity;
import com.spring.entity.UserEntity;
import com.spring.json.Election;
import com.spring.json.LoginResponse;
import com.spring.json.UserCredentials;
import com.spring.repository.AdminRepository;
import com.spring.repository.PartyRepository;
import com.spring.repository.UserCredentialsRepository;
import com.spring.service.AdminService;



@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	private PartyRepository partyRepository;

	@Autowired
	private UserCredentialsRepository userCredentialsRepository;

	public Object addElection(ElectionEntity election, String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionId(sessionId);
		if(userCredentialsEntity != null) {
			String id = generateRandomString(6);
			election.setElectionid(id);
			adminRepository.save(election);
			return election;
		}
		else {
		 LoginResponse loginResponse=new LoginResponse();
		 loginResponse.setMessage("INVALID SESSION ID");
		 loginResponse.setResult("unsucessfull");
		 loginResponse.setSessionId(null);
		 return loginResponse;
		}
		
	}
	@Override
	public Object addParty(PartyEntity party, String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionId(sessionId);
		if(userCredentialsEntity != null) {
		String id = generateRandomString(6);
		party.setPartyid(id);
		partyRepository.save(party);
		return party;
		}
		else {
		 LoginResponse loginResponse=new LoginResponse();
		 loginResponse.setMessage("INVALID SESSION ID");
		 loginResponse.setResult("unsucessfull");
		 loginResponse.setSessionId(null);
		 return loginResponse;
		}			
		}
	
	
	public Object getElectionDetails(String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionId(sessionId);
		if(userCredentialsEntity != null) {
			List<ElectionEntity> electionList = new ArrayList<>();
			adminRepository.findAll().forEach(electionList::add);
			return electionList;
		}
		else {
			LoginResponse loginResponse=new LoginResponse();
			 loginResponse.setMessage("INVALID SESSION ID");
			 loginResponse.setResult("unsucessfull");
			 loginResponse.setSessionId(null);
			 return loginResponse;
		}
	}
	
	public Object getPartyDetails(String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionId(sessionId);
		if(userCredentialsEntity != null) {
		List<PartyEntity> partyList = new ArrayList<>();
		partyRepository.findAll().forEach(partyList::add);
		return partyList;
		}
		else {
			LoginResponse loginResponse=new LoginResponse();
			 loginResponse.setMessage("INVALID SESSION ID");
			 loginResponse.setResult("unsucessfull");
			 loginResponse.setSessionId(null);
			 return loginResponse;
		}
	}
	
	/*
	 * @Override public Object getAllElectionFromElectionDate(LocalDate date,String
	 * sessionId) { UserCredentialsEntity userCredentialsEntity =
	 * userCredentialsRepository.findBySessionId(sessionId);
	 * if(userCredentialsEntity != null) { List<ElectionEntity> electionDateList =
	 * new ArrayList<>();
	 * adminRepository.findByDateGreaterThanEqual(date).forEach(electionDateList::
	 * add); return electionDateList; } else { LoginResponse loginResponse=new
	 * LoginResponse(); loginResponse.setMessage("INVALID SESSION ID");
	 * loginResponse.setResult("unsucessfull"); loginResponse.setSessionId(null);
	 * return loginResponse; } }
	 */
		

	private final Random random = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public String generateUserId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {
		StringBuilder stringBuilder = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			stringBuilder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
		}
		return stringBuilder.toString();
	}


	public List<ElectionEntity> getElectionDetails() {
		List<ElectionEntity> electionList = new ArrayList<>();
		adminRepository.findAll().forEach(electionList::add);
		return electionList;
	}



	@Override
	public LoginResponse adminLogin(UserCredentials user) {
		UserCredentials newUser = new UserCredentials();
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findById(user.getUserid()).get();
		BeanUtils.copyProperties(userCredentialsEntity, newUser);
		String sessionId = null;
		LoginResponse response = new LoginResponse();
		if (newUser.getUserid().equals(user.getUserid()) && newUser.getPassword().equals(user.getPassword())
				&& user.getUsertype().equals("1") && newUser.getUsertype().equals("1")) {
			sessionId = generateRandomString(6);
			userCredentialsEntity.setSessionId(sessionId);
			userCredentialsEntity.setLoginStatus(1);
			userCredentialsRepository.save(userCredentialsEntity);
			response.setMessage("Login Successful-admin");
			response.setResult("Success");
			response.setSessionId(sessionId);

		} else if (newUser.getUserid().equals(user.getUserid()) && newUser.getPassword().equals(user.getPassword())
				&& user.getUsertype().equals("2")  && newUser.getUsertype().equals("2")) {
			sessionId = generateRandomString(6);
			userCredentialsEntity.setSessionId(sessionId);
			userCredentialsEntity.setLoginStatus(1);
			userCredentialsRepository.save(userCredentialsEntity);
			response.setMessage("Login Successful-electoral");
			response.setResult("Success");
			response.setSessionId(sessionId);

		}else if (newUser.getUserid().equals(user.getUserid()) && newUser.getPassword().equals(user.getPassword())
				&& user.getUsertype().equals("3")  && newUser.getUsertype().equals("3")) {
			sessionId = generateRandomString(6);
			userCredentialsEntity.setSessionId(sessionId);
			userCredentialsEntity.setLoginStatus(1);
			userCredentialsRepository.save(userCredentialsEntity);
			response.setMessage("Login Successful-voter");
			response.setResult("Success");
			response.setSessionId(sessionId);

		}else {
			response.setMessage("Login UnSuccessful");
			response.setResult("Failure");
			response.setSessionId(null);
		}
		return response;
	}

	@Override
	public LoginResponse adminLogout(String sessionId) {
		LoginResponse response = new LoginResponse();
		if (sessionId == null) {
			response.setMessage("INVALID SESSIONID");
		} else {
			UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionId(sessionId);
			//System.out.println(
			//		"===========================================================================>" + sessionId);
			userCredentialsEntity.setSessionId(null);
			userCredentialsEntity.setLoginStatus(0);

			userCredentialsRepository.save(userCredentialsEntity);
			response.setMessage("LOGGED OUT SUCCESFULLY");
		}
		return response;
	}

	

		
	}


