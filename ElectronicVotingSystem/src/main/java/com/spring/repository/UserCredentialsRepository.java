package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.UserCredentialsEntity;

public interface UserCredentialsRepository extends JpaRepository<UserCredentialsEntity, String> {

	UserCredentialsEntity findBySessionId(String sessionId);

}
