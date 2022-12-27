package com.jdc.location.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.location.model.dto.DistrictDto;
import com.jdc.location.model.entity.District;

public interface DistrictProjectionRepo extends JpaRepository<District, Integer>{

	List<DistrictDto> findByStateId(int id);
}
