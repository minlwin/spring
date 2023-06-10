package com.jdc.location.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.location.model.entity.State;

public interface StateRepo extends JpaRepositoryImplementation<State, Integer>{

	long deleteByRegion(String region);

}
