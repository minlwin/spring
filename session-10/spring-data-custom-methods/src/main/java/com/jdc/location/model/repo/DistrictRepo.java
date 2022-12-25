package com.jdc.location.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.location.model.entity.District;

public interface DistrictRepo extends JpaRepository<District, Integer>{

	List<District> findByStateRegion(String region);
	
	List<District> findByNameStartingWithIgnoringCaseOrderByName(String name);
	
	List<District> findByStateIdAndNameStartingWithIgnoringCaseOrderByName(int stateId, String name);
	
}
