package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.service.DistrictService;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class CommonCustomRepositoryTest {

	@Autowired
	private DistrictService service;
	
	@ParameterizedTest
	@CsvSource({
		",,,82",
		"West,,,9",
		"West,3,,4",
		"West,3,Falam,1",
		",,Falams,0",
	})
	void test(String region, Integer stateId, String name, int size) {
		var result = service.search(region, stateId, name);
		assertThat(result, hasSize(size));
	}
}
