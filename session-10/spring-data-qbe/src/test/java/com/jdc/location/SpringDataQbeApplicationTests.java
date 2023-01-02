package com.jdc.location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.repo.StateRepo;

@SpringBootTest
class SpringDataQbeApplicationTests {
	
	@Autowired
	private StateRepo repo;

	@Test
	void find_by_capital_and_region() {
		
		// Build Probe for constraint
		var probe = new State();
		probe.setRegion("East");
		probe.setCapital("Taunggyi");
		
		// Create Example with probe
		var example = Example.of(probe, 
				ExampleMatcher.matching().withIgnorePaths("id", "porpulation"));
		
		// Search
		var list = repo.findAll(example);
		
		assertThat(list, hasSize(1));
	}
	
	@Test
	void find_by_name_start_ignore_case() {
		
		var probe = new State();
		probe.setName("m");
		
		var example = Example.of(probe,
				ExampleMatcher.matching()
					.withIgnorePaths("id", "porpulation")
					.withIgnoreNullValues()
					.withIgnoreCase()
					.withStringMatcher(StringMatcher.STARTING));
		
		var result = repo.findAll(example);
		assertThat(result, hasSize(3));
	}

}
