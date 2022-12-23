package com.jdc.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.config.JpaConfiguration;
import com.jdc.location.model.entity.State;
import com.jdc.location.model.entity.State.Type;
import com.jdc.location.model.repo.StateRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class SaveMethodsTest {
	
	@Autowired
	private StateRepo repo;

	@ParameterizedTest
	@Sql(scripts = "/init-state.sql")
	@CsvFileSource(resources = "/save/test_insert.txt", delimiter = '\t')
	void test_insert(String name, Type type, String region, String capital, int porpulation) {
		
		// Prepare Inputs
		var input = new State(name, type, region, capital, porpulation);
		
		// Execute Test Method
		var result = repo.save(input);
		
		// Check Result
		assertThat(result, hasProperty("id", is(1)));
	}
}
