package com.jdc.location.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.repo.StateRepo;

@Service
public class StateService {

	@Autowired
	private StateRepo repo;
	
	public Optional<State> findByName(String name) {
		
		// Create Probe Object
		var probe = new State();
		
		// Set Properties for query constraint
		probe.setName(name);
		
		// Execute Query by Example APIs
		return repo.findOne(Example.of(probe, ExampleMatcher.matching().withIgnorePaths("id", "porpulation").withIgnoreNullValues()));
	}
	
	public List<State> nameIsStartWith(String name) {

		// Create Probe Object
		var probe = new State();
		probe.setName(name);
		
		// Create Example Matchers
		var matcher = ExampleMatcher.matching().withIgnoreNullValues()
				.withMatcher("name", m -> m.startsWith().ignoreCase());
		
		return repo.findAll(Example.of(probe, matcher));
	}
}
