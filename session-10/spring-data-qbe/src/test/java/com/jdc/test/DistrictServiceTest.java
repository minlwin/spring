package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.service.DistrictService;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class DistrictServiceTest {

	@Autowired
	private DistrictService service;
	
	@Test
	void test() {
		
		var result = service.findByStateAndName(1, "Hinthada").get();
		assertThat(result, allOf(
			hasProperty("id", is(1)),
			hasProperty("name", is("Hinthada"))));
	}
}
