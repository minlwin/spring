package com.jdc.location.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.repo.StateRepo;

@Service
public class StateSpecService {

	@Autowired
	private StateRepo repo;
	
	// select s from State s where s.region = region
	public List<State> findByRegion(String region) {
		
		Specification<State> specification = (root, query, cb) -> 
			cb.equal(root.get("region"), region);
		
		return repo.findAll(specification);
	}
}
