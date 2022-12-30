package com.jdc.location.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.entity.State.Type;

public interface StateRepo extends JpaRepository<State, Integer>{

	State findOneByName(@NonNull String name);
	
	List<State> findByTypeAndName(Type type, String name);
}
