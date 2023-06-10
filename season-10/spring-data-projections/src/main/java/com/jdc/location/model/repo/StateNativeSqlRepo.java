package com.jdc.location.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.record.StateWithDistrictCountRecord;

public interface StateNativeSqlRepo extends JpaRepository<State, Integer>{

	@Query(name = "State.natvieWithCountById", nativeQuery = true)
	StateWithDistrictCountRecord findById(int id);
}
