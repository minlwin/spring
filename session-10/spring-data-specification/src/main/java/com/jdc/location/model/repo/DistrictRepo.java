package com.jdc.location.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.location.model.entity.District;

public interface DistrictRepo extends JpaRepositoryImplementation<District, Integer> {

}
