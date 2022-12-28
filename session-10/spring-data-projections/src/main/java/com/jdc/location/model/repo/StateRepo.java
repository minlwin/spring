package com.jdc.location.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.location.model.dto.StateValueDto;
import com.jdc.location.model.dto.StateWithDistrictCount;
import com.jdc.location.model.entity.State;

public interface StateRepo extends JpaRepository<State, Integer>{

	@Query("""
		select s.id id, s.name name, size(s.district) districtCount
		from State s where s.region = ?1""")
	List<StateWithDistrictCount> searchStateList(String region);
	
	StateValueDto findOneById(int id);
}
