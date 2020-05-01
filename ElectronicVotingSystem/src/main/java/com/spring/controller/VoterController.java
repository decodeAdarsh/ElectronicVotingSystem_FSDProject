package com.spring.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.UserEntity;
import com.spring.json.User;
import com.spring.service.VoterService;

@RestController
@RequestMapping("/evs")
public class VoterController {

	@Autowired
	private VoterService voterService;
	
	@PostMapping(value="/evs/voter", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object registerVoter(@RequestBody User user,UserEntity userEntity, @RequestHeader(name="userid") String userid) {
		BeanUtils.copyProperties(user, userEntity);
		return voterService.registerVoter(userEntity, userid);
	}
}
