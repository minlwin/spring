package com.jdc.location.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.entity.District;
import com.jdc.location.model.entity.State;
import com.jdc.location.model.repo.DistrictRepo;

@Service
@Transactional(readOnly = true)
public class DistrictService {

	@Autowired
	private DistrictRepo repo;
	
	public Optional<District> findByStateAndName(int stateId, String name) {
		var district = new District();
		var state = new State();
		state.setId(stateId);
		district.setState(state);
		district.setName(name);
		return repo.findOne(Example.of(district));
	}
}
