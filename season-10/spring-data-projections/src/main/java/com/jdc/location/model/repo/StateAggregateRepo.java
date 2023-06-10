package com.jdc.location.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.record.StateWithDistrictCountRecord;

public interface StateAggregateRepo extends JpaRepository<State, Integer>{

	@Query("""
		select new com.jdc.location.model.record.StateWithDistrictCountRecord(
		s.id, s.name, size(s.district)) from State s where s.id = :id""")
	StateWithDistrictCountRecord findOneById(@Param("id") int id);
}
