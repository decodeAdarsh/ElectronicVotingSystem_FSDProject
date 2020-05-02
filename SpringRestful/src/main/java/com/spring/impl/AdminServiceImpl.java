package com.spring.impl;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.CandidateEntity;
import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.entity.ResultEntity;
import com.spring.entity.UserCredentialsEntity;


import com.spring.json.LoginResponse;
import com.spring.json.Result;
import com.spring.json.UserCredentials;
import com.spring.repository.AdminRepository;
import com.spring.repository.ApplicationRepository;
import com.spring.repository.CandidateRepository;
import com.spring.repository.ElectionRepository;
import com.spring.repository.PartyRepository;
import com.spring.repository.ResultRepository;
import com.spring.repository.UserCredentialsRepository;

import com.spring.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ElectionRepository electionRepository;
	
	
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private PartyRepository partyRepository;
	
	@Autowired
	private ResultRepository resultRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;

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


	


	@Override
	public Object addCandidate(CandidateEntity candidate, String sessionId,String electionid ) {
		
			UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionId(sessionId);
	
			ElectionEntity electionEntity=adminRepository.findByElectionid(electionid);
			if(userCredentialsEntity != null) {
				String id = generateRandomString(6);
				candidate.setCandidateId(id);
				candidateRepository.save(candidate);
				return candidate;
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
	public Object getCandidateDetails(String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionId(sessionId);
	//ElectionEntity electionEntity=adminRepository.findByElectionid(electionid);
		if(userCredentialsEntity != null) {
			List<CandidateEntity> candidateList = new ArrayList<>();
			candidateRepository.findAll().forEach(candidateList::add);
			return candidateList;
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
	public List<PartyEntity> getPartyDetails(String sessionId) {
	
			List<PartyEntity> partyList = new ArrayList<>();
			partyRepository.findAll().forEach(partyList::add);
			return partyList;
		
	}



	@Override
	public Object  updateRequest(ApplicationEntity applicationEntity,String sessionId,String userid) {
		
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.
				findBySessionId(sessionId);
		
		
		if(userCredentialsEntity != null) {
			ApplicationEntity app=applicationRepository.findByUserId(userid);
			if(app!=null) {
		    app.setApprovedStatus(app.getApprovedStatus());
		    app.setPassedStatus(app.getPassedStatus());
		    app.setConstituency(app.getConstituency());
		    applicationRepository.save(app);
		    return app;
			}
			else
				return "{\"result\": \"failure\",\"message\": \"Wrong User Id\"}";
		}
		else 
		{
		
			return "{\"result\": \"failure\",\"message\": \"Wrong Session Id\"}";
	}


}
	@Override
	public List<ApplicationEntity>  getRequest(String sessionId) {
		
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.
				findBySessionId(sessionId);
		
		
		if(userCredentialsEntity != null) {
		
	
		return applicationRepository.findByApprovedStatus(0);
			
		}
       return null;
    }
	
	@Override
	public List<String> candidatesByParty(String partyName) {
		List<PartyEntity> partyEntity=partyRepository.findByName(partyName);
		PartyEntity party=partyEntity.get(0);
		String id=party.getPartyid();
		List<CandidateEntity> candidateList=candidateRepository.findByPartyid(id);
		List<String> candidate=candidateList.stream().map(CandidateEntity::getName).collect(Collectors.toList());
		return candidate;
	}


	@Override
	public Object update(String candidateid, ResultEntity resultent, String sessionId) {
		UserCredentialsEntity userCred=userCredentialsRepository.findBySessionId(sessionId);
		Result result=new Result();
		if(userCred!=null)
		{
			resultent=resultRepository.findByCandidateId(candidateid);
			if(resultent!=null) {
				resultent.setElectionId(result.getElectionId());
				resultent.setCandidateId(result.getCandidateId());
				resultent.setVoteCount(result.getVoteCount());
				resultent.setResultStatus(result.getResultStatus());
				resultent=resultRepository.save(resultent);
				return resultent;
			}
			else
				return "{\"result\": \"failure\",\"message\": \"Wrong candidate Id\"}";
		}
		else {
			return "{\"result\": \"failure\",\"message\": \"Wrong Session Id\"}";
		}
	}


	@Override
	public Boolean deletebyElectionId(String electionId, String sessionId) {
			
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionId(sessionId);
		if(userCredentialsEntity != null) {
			List<ElectionEntity> elect=electionRepository.findByElectionid(electionId);
			ElectionEntity el=elect.get(0);
				electionRepository.delete(el);		
	       	return true;
		}
			else {
				return false;
		}	
	}


	@Override
	public Boolean deletebyCandidateId(String candidateid, String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionId(sessionId);
		if(userCredentialsEntity != null) {
			List<CandidateEntity> candy=candidateRepository.findByCandidateId(candidateid);
			CandidateEntity can=candy.get(0);
				candidateRepository.delete(can);		
	       	return true;
		}
			else {
				return false;
		}	
	}
	

}


