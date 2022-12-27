package com.jdc.demo.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.repo.DistrictProjectionRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
@Sql(scripts = {
		"/init-tables.sql",
		"/load-data.sql"
})
public class DistrictRepoTest {

	@Autowired
	private DistrictProjectionRepo repo;
	
	@ParameterizedTest
	@CsvSource({
		"1,8"
	})
	void test(int state, int size) {
		var result = repo.findByStateId(state);
		assertThat(result, hasSize(size));
	}
}
