package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.repo.DistrictProjInfRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class ProjectionOrNotTest {

	@Autowired
	private DistrictProjInfRepo repo;
	
	@ParameterizedTest
	@CsvSource("1,8")
	void test(int state, int size) {
		var result = repo.findByStateId(state);
		assertThat(result, hasSize(size));
	}
}
