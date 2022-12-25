package com.jdc.location.model.repo;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.entity.State.Type;

@Transactional(readOnly = true)
public interface StateRepo extends JpaRepository<State, Integer>{

	// What we want & How we search
	List<State> queryByType(Type type);

	Stream<State> streamByType(Type type);
	
	long countByRegion(String region);
	
	boolean existsByRegion(String region);
	
	State findOneByName(String name);
	
	List<State> findDistinctByType(Type type);
	
	@Transactional
	void removeByType(Type type);
	
	List<State> findTop3ByType(Type type);
	
	long countByType(Type type);
}
