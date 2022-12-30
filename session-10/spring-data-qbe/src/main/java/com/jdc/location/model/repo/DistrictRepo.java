package com.jdc.location.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.location.model.entity.District;

public interface DistrictRepo extends JpaRepository<District, Integer> {

}
