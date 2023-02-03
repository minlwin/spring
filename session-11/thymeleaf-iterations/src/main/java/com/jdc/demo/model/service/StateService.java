package com.jdc.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.model.entity.State;
import com.jdc.demo.model.repo.StateRepo;

@Service
@Transactional(readOnly = true)
public class StateService {

	@Autowired
	private StateRepo repo;
	
	public List<State> findAll() {
		return repo.findAll();
	}
}
