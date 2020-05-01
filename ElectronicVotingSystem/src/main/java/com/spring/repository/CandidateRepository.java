package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.CandidateEntity;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, String> {
	List<CandidateEntity> findByPartyid(String id);

}
