package com.spring.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.entity.UserEntity;
import com.spring.json.Application;
import com.spring.json.User;
import com.spring.repository.ApplicationRepository;
import com.spring.repository.ElectoralRepository;
import com.spring.service.ElectoralServices;

@Service
public class ElectoralServiceImpl implements ElectoralServices {
	
	@Autowired
	private ApplicationRepository applicationrepo;
	private ElectoralRepository electoral;

	@Override
	public List<Application> getApprovedUser(Application application) {
		return applicationrepo.findAll(Sort.by("approvedStatus(sucess)"));
	}

	@Override
	public User update(User user, String voterid) {
			UserEntity userEntity = userRepository.findById(String.valueOf(voterid)).get();
			if(userEntity != null) {
				userEntity.setFirstName(user.getFirstName());
				userEntity.setLastName(user.getLastName());
				userEntity.setDateOfBirth(user.getDateOfBirth());
				userEntity.setGender(user.getGender());
				userEntity.setStreet(user.getStreet());
				userEntity.setLocation(user.getLocation());
				userEntity.setCity(user.getCity());
				userEntity.setState(user.getState());
				
				
				userEntity = userRepository.save(userEntity);
				return userEntity;
			}
			return null;
		}
	}
	
	
}