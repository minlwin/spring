package com.jdc.location.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.dto.StateDto;
import com.jdc.location.model.entity.District;
import com.jdc.location.model.entity.State;
import com.jdc.location.model.repo.DistrictRepo;
import com.jdc.location.model.repo.StateRepo;

@Service
@Transactional(readOnly = true)
public class StateSpecService {

	@Autowired
	private StateRepo stateRepo;
	
	@Autowired
	private DistrictRepo districtRepo;

	// select s from State s where s.region = region
	public List<State> findByRegion(String region) {
		return stateRepo.findAll(byRegion(region));
	}

	public long findCountByRegion(String region) {
		return stateRepo.count(byRegion(region));
	}
	
	public List<StateDto> findDtoByRegion(String region) {
		return stateRepo.findBy(byRegion(region), query -> query
				.project("id", "name", "region")
				.as(StateDto.class).all());
	}
	
	@Transactional
	public long deleteByRegion(String region) {
		
		// Delete District
		deleteDistrictByRegion(region);
		
		return stateRepo.delete(byRegion(region));
	}
	
	@Transactional
	private long deleteDistrictByRegion(String region) {
		
		Specification<District> sepec = (root, query, cb) -> 
			cb.equal(root.get("state").get("region"), region);
		
		return districtRepo.delete(sepec);
	}

	private Specification<State> byRegion(String region) {
		return (root, query, cb) -> cb.equal(root.get("region"), region);
	}
	
}
