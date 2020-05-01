  package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.UserEntity;
import com.spring.impl.AdminServiceImpl;
import com.spring.json.Application;
import com.spring.json.User;
import com.spring.service.ElectoralServices;

@RestController
@RequestMapping("/evs/election")
public class ElectoralController {

		@Autowired
		private com.spring.impl.ElectoralServiceImpl services;
		private  UserServiceImpl user;
		private AdminServiceImpl admin;
		
		@GetMapping("/voter/request")
		public List<Application> getApprovedVoter(){
			return 
		}
		
		 @PutMapping(value= "/voter/{voterid}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
		 public @ResponseBody UserEntity updateUsers(@RequestBody User user,@PathVariable(value="voterid") String voterid) {
			 return user.update(user , voterid);
;					 
	}

}