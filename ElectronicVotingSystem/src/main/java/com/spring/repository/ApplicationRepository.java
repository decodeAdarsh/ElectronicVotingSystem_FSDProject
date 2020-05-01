package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.json.Application;

public interface ApplicationRepository extends JpaRepository<Application, String>{

}
