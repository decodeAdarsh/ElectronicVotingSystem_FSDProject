package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.ElectionEntity;

@Repository
public interface AdminRepository extends JpaRepository<ElectionEntity, String> {

}
