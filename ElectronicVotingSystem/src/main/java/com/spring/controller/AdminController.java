package com.spring.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.entity.UserCredentialsEntity;
import com.spring.json.Election;
import com.spring.json.LoginResponse;
import com.spring.json.Party;
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
	//	return electionEntity;
	}
	@PostMapping(value="/party", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public PartyEntity  addPartyDetails(@RequestBody Party party,PartyEntity partyEntity)
	{ BeanUtils.copyProperties(party, partyEntity);
		 adminService.addParty(partyEntity);
		return partyEntity;
	}
	
	
	


	@GetMapping("/election")
	public Object getElectionDetails(@RequestHeader(name = "sessionId") String sessionId) {
		return adminService.getElectionDetails(sessionId);
	}
	
	@GetMapping(value="/party")
		public List<PartyEntity> getPartyDetails(){
			return adminService.getPartyDetails();
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

}
