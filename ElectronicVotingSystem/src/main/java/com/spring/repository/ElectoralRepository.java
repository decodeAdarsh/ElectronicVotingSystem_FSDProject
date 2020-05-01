package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.json.ElectoralOfficer;

public interface ElectoralRepository  extends JpaRepository<ElectoralOfficer, String> {

}
