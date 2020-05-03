package com.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.ElectionEntity;


public interface ElectionRepository extends JpaRepository<ElectionEntity, String> {
	Boolean existsByElectionid(String electionid);
	Boolean deleteByElectionid(String electionId);
	List<ElectionEntity> findByElectionid(String electionId);
}
