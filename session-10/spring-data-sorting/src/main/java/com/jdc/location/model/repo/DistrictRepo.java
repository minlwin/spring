package com.jdc.location.model.repo;

import java.util.List;

import static org.hibernate.jpa.AvailableHints.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.entity.District;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;

@Transactional
public interface DistrictRepo extends JpaRepositoryImplementation<District, Integer>{

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints(@QueryHint(name = HINT_SPEC_LOCK_TIMEOUT, value = "3"))
	List<District> findByStateRegion(String region);

	List<District> findByStateRegionOrderByName(String region);
	
	List<District> findByStateRegion(String region, Sort sort);

	Page<District> findByStateRegion(String region, Pageable pageable);
	
	@Query("select d from District d where d.state.region = ?1 order by d.name desc")
	List<District> searchByRegionDescName(String region);

	@Query("select d from District d where d.state.region = ?1")
	List<District> searchByRegion(String region, Sort sort);
	
	@Query(
		value = "select d from District d where d.state.region = ?1",
		countQuery = "select count(d) from District d where d.state.region = ?1"
	)
	Page<District> searchByRegion(String region, Pageable pageable);
	
}
