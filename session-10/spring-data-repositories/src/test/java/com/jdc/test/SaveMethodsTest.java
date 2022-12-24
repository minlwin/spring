package com.jdc.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
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
		var result = repo.saveAndFlush(input);
		
		// Check Result
		assertThat(result, hasProperty("id", is(1)));
	}
	
	@ParameterizedTest
	@Sql(scripts = {
			"/init-state.sql",
			"/load-data.sql"
	})
	@CsvSource({
		"1,Test Name,Region,East,Test Capital,10000"
	})
	void test_update(int id, String name, Type type, String region, String capital, int porpulation) {
		
		var input = new State(id, name, type, region, capital, porpulation);
		
		repo.save(input);
		
		var result = repo.findById(id).get();
		
		assertThat(result, allOf(
			notNullValue(),
			hasProperty("id", is(id)),
			hasProperty("name", is(name)),
			hasProperty("type", is(type)),
			hasProperty("region", is(region)),
			hasProperty("capital", is(capital)),
			hasProperty("porpulation", is(porpulation))
		));
	}
}
