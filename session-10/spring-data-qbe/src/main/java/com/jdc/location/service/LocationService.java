package com.jdc.location.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.repo.StateRepo;

@Service
@Transactional(readOnly = true)
public class LocationService {
	
	@Autowired
	private StateRepo stateRepo;

	public Stream<State> findByRegionAsStream(String region) {
		return stateRepo.findBy(
				Example.of(
						new State(region),
						ExampleMatcher.matching()
							.withIgnorePaths("id", "porpulation"))
				, query -> query.stream());
	}
	
	public Optional<State> findFirstByRegion(String region) {
		return stateRepo.findBy(
				Example.of(
					new State(region),
					ExampleMatcher.matching()
						.withIgnorePaths("id", "porpulation")), 
				query -> query.sortBy(Sort.by("name")).first());
	}
}
