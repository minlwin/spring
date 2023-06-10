package com.jdc.location.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.repo.StateRepo;

@Service
public class StateService {

	@Autowired
	private StateRepo repo;
	
	@Transactional
	public long deleteByRegion(String region) {
		return repo.deleteByRegion(region);
	}
}
