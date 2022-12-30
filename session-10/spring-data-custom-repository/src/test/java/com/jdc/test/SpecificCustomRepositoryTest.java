package com.jdc.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.entity.State.Type;
import com.jdc.location.model.repo.StateRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class SpecificCustomRepositoryTest {

	@Autowired
	private StateRepo repo;
	
	@ParameterizedTest
	@CsvSource({
		",,,15",
		"State,,,7",
		",West,,2",
		",,ka,3",
		",North,ka,1",
		"Region,North,ka,0",
	})
	void test_search(Type type, String region, String name, int size) {
		var result = repo.search(type, region, name);
		assertThat(result, hasSize(size));
	}
}
