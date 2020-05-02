package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.PartyEntity;

@Repository
public interface PartyRepository extends JpaRepository<PartyEntity, String> {
	List<PartyEntity> findByName(String name);

}
