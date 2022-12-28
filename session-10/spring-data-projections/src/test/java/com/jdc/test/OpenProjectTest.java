package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.repo.StateRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class OpenProjectTest {

	@Autowired
	private StateRepo repo;
	
	@Test
	void test() {
		var result = repo.findOneById(1);
		
		assertThat(result, allOf(
			notNullValue(),
			hasProperty("id", is(1)),
			hasProperty("displayName", is("Ayeyarwady Region"))
		));
	}
}
