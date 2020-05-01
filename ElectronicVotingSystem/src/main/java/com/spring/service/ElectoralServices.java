package com.spring.service;

import java.util.List;

import com.spring.json.Application;
import com.spring.json.User;

public interface ElectoralServices {
	
	List<Application> getApprovedUser(Application application );
	 User update(User user, String voterid);
}
