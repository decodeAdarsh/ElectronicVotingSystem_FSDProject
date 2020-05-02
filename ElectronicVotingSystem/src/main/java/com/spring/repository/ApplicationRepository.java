package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.ApplicationEntity;


public interface ApplicationRepository extends JpaRepository<ApplicationEntity, String> {
       
		ApplicationEntity findByUserid(String userid);
		
		List<ApplicationEntity> findByApprovedstatus(int approvedstatus);
}
