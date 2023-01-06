package com.jdc.location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.location.model.service.StateSpecService;

@SpringBootTest
class SpringDataSpecificationApplicationTests {

	@Autowired
	private StateSpecService service;
	
	@Test
	void test_criteria_query() {
		var list = service.findByRegion("East");
		assertThat(list, hasSize(2));
	}

}
