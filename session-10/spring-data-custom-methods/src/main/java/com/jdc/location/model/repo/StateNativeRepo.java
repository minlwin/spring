package com.jdc.location.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.location.model.entity.State;

public interface StateNativeRepo extends JpaRepository<State, Integer>{

	@Query(nativeQuery = true)
	List<State> findWithNativeSql(@Param("type") String type);
}
