package com.test.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.dbservice.entity.Quotes;

public interface QuotesRepository extends JpaRepository<Quotes, Integer>{

	List<Quotes> findByUserName(String userName);

}
