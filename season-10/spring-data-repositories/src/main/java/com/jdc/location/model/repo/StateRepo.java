package com.jdc.location.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.location.model.entity.State;

public interface StateRepo extends JpaRepository<State, Integer>{

}
