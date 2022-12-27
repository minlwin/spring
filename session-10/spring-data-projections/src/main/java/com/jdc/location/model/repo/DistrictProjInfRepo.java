package com.jdc.location.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.location.model.dto.DistrictDtoInf;
import com.jdc.location.model.entity.District;

public interface DistrictProjInfRepo extends JpaRepository<District, Integer>{

	List<DistrictDtoInf> findByStateId(int state);

}
