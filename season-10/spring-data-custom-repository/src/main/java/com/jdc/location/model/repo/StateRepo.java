package com.jdc.location.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.repo.custom.StateCustomRepo;

public interface StateRepo extends 
	JpaRepository<State, Integer>,
	StateCustomRepo{

	State findOneByName(@NonNull String name);
	
}
