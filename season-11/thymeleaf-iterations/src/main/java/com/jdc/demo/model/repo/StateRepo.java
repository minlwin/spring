package com.jdc.demo.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.model.entity.State;

public interface StateRepo extends JpaRepositoryImplementation<State, Integer>{

}
