package com.jdc.location.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.record.StateRecord;

public interface StateRecordRepo extends JpaRepository<State, Integer>{

	StateRecord findOneById(int id);
}
