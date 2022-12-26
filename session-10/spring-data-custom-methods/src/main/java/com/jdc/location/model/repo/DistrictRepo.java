package com.jdc.location.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.location.model.entity.District;

public interface DistrictRepo extends JpaRepository<District, Integer>{

	List<District> findByStateRegion(String region);
	
	List<District> findByNameStartingWithIgnoringCaseOrderByName(String name);
	
	List<District> findByStateIdAndNameStartingWithIgnoringCaseOrderByName(int stateId, String name);
	
	@Query(name = "District.findForState")
	List<District> findWithNamedQuery(@Param("stateId") int id, @Param("name") String name);
	
	@Query(value = """
			select d from District d where d.state.id = :stateId 
			and lower(d.name) like lower(:name) order by d.name""")
	List<District> findWithQueryAnnotation(@Param("stateId") int id, @Param("name") String name);
}
