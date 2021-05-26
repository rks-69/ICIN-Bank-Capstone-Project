package com.icin.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.icin.domain.Request;

public interface RequestDao extends CrudRepository<Request, Long> {
	
	List<Request> findAll();

}
