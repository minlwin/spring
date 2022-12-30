package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.service.StateService;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class StateServiceTest {

	@Autowired
	private StateService service;
	
	@Test
	void test() {
		var result = service.findByName("Ayeyarwady").get();
		assertThat(result, allOf(
			hasProperty("id", is(1)),
			hasProperty("name", is("Ayeyarwady"))
		));
	}
}
