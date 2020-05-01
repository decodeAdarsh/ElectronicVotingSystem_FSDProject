package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


import com.spring.entity.ResultEntity;

@Component
public interface ResultRepository extends JpaRepository<ResultEntity, Long> {
	ResultEntity findByCandidateid(String id);

}
