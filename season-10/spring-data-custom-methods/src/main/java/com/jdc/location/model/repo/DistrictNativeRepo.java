package com.jdc.location.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.location.model.entity.District;

public interface DistrictNativeRepo extends JpaRepository<District, Integer>{

	@Query(
		nativeQuery = true,
		value = "select * from district where state_id = ?")
	List<District> findWithNativeSql(int stateId);
}
