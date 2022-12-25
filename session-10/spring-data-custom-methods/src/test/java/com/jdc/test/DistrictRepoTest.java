package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.repo.DistrictRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
@Sql(scripts = {
		"/init-tables.sql",
		"/load-data.sql"
})
public class DistrictRepoTest {

	@Autowired
	private DistrictRepo repo;
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"West,9"
	})
	void test_find_by_state_region(String region, int size) {
		var result = repo.findByStateRegion(region);
		assertThat(result, hasSize(size));
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource("Hpa,2")
	void test_find_by_name_starting_with(String name, int size) {
		var result = repo.findByNameStartingWithIgnoringCaseOrderByName(name);
		assertThat(result, hasSize(size));
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource("13,mo,3")
	void test_find_by_state_and_name(int stateId, String name, int size) {
		var result = repo.findByStateIdAndNameStartingWithIgnoringCaseOrderByName(stateId, name);
		assertThat(result, hasSize(size));
	}

	@ParameterizedTest
	@CsvSource("13,mo,3")
	void test_find_by_named_query(int stateId, String name, int size) {
		var result = repo.findForStateAndName(stateId, name.concat("%"));
		assertThat(result, hasSize(size));
	}
}
