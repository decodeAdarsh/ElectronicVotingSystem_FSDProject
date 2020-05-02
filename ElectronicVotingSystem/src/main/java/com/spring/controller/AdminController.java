package com.spring.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.CandidateEntity;
import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.entity.ResultEntity;
import com.spring.entity.UserCredentialsEntity;
import com.spring.json.Application;
import com.spring.json.Candidate;
import com.spring.json.Election;
import com.spring.json.LoginResponse;
import com.spring.json.Party;
import com.spring.json.Result;
import com.spring.json.UserCredentials;
import com.spring.service.AdminService;

@RestController
@RequestMapping("/evs")
public class AdminController {

	@Autowired
	private AdminService adminService;

	private String sessionId = null;

	@PostMapping("/election")
	public Object addElectionDetails(@RequestBody Election election, ElectionEntity electionEntity, @RequestHeader(name = "sessionId") String sessionId) {
		BeanUtils.copyProperties(election, electionEntity);
		return adminService.addElection(electionEntity,sessionId);
	}
	
	
	@PostMapping("/election/{electionid}/party/{partyid}/candidate")
	public Object addCandidateDetails(@RequestBody Candidate candidate, CandidateEntity candidateEntity, @RequestHeader(name = "sessionId")
	String sessionId,@PathVariable(name="electionid") String electionid,@PathVariable(name="partyid") String partyid) {
		BeanUtils.copyProperties(candidate, candidateEntity);
		return adminService.addCandidate(candidateEntity,sessionId,electionid);
	}
	
	@PostMapping(value="/party", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public PartyEntity  addPartyDetails(@RequestBody Party party,PartyEntity partyEntity)
	{ BeanUtils.copyProperties(party, partyEntity);
		 adminService.addParty(partyEntity, sessionId);
		return partyEntity;
	}
	
	
	@GetMapping("/election")
	public Object getElectionDetails(@RequestHeader(name = "sessionId") String sessionId) {
		return adminService.getElectionDetails(sessionId);
	}

	
	
	@GetMapping("/candidate")
	public Object getCandidateDetails(@RequestHeader(name = "sessionId") String sessionId
			) {
		return adminService.getCandidateDetails(sessionId);
	}
	
	@GetMapping(value="/party")
		public List<PartyEntity> getPartyDetails(){
			return adminService.getPartyDetails(sessionId);
		}
		
	@GetMapping(value="/application/request")
	public List<ApplicationEntity> getRequest(){
		return adminService.getRequest(sessionId);
	}
	
	@PostMapping(value="/application/{userid}/update",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object updateRequest(@RequestBody ApplicationEntity 
			applicationEntity,Application
			application,@RequestHeader(name = "sessionId") String sessionId,
			@PathVariable(name="userid") String userid
			){
       BeanUtils.copyProperties(application,applicationEntity);
		return adminService.updateRequest(applicationEntity,userid,sessionId);
	}

	@PostMapping("/login")
	public LoginResponse loginAdmin(@RequestBody UserCredentials userCredentials,
			UserCredentialsEntity userCredentialsEntity) {
		LoginResponse res = adminService.adminLogin(userCredentials);
		sessionId = res.getSessionId();
		return res;
	}

	@GetMapping("/logout")
	public LoginResponse logoutAdmin() {
		return adminService.adminLogout(sessionId);
	}
	
	@GetMapping(value="party/candidate/{name}")
	public List<String> detailsByParty(@PathVariable(name="name") String partyName){
		return adminService.candidatesByParty(partyName);	
	}
	
	@PutMapping(value="/election/results/approval/{candidateId}",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object resultStatus(@PathVariable(value="candidateId") String candidateid,@RequestBody Result result,ResultEntity resultEntity,@RequestHeader(name="sessionId") String sessionId) {
        BeanUtils.copyProperties(result, resultEntity); 
		return adminService.update(candidateid,resultEntity,sessionId);
		
	}
	@DeleteMapping(value="election/delete/{electionid}")
	public Boolean deleteElectionById(@PathVariable(value="electionid") String electionId,@RequestHeader(name="sessionId") String sessionid) {
		return adminService.deletebyElectionId(electionId,sessionId);
		
	}
	
	@DeleteMapping(value="voter/delete/{candidateId}")
	public Boolean deleteCandidateById(@PathVariable(value="candidateId") String candidateid,@RequestHeader(name="sessionId") String sessionid) {
		return adminService.deletebyCandidateId(candidateid,sessionId);
		
	}

}
