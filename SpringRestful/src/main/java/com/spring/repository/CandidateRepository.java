package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.CandidateEntity;


public interface CandidateRepository extends JpaRepository<CandidateEntity, String> {
	List<CandidateEntity> findByPartyid(String id);

	List<CandidateEntity> findByCandidateId(String candidateid);	
}
