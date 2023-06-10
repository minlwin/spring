package com.jdc.location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

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
	
	@Test
	void test_count_method() {
		var count = service.findCountByRegion("East");
		assertThat(count, is(2L));
	}
	
	@Test
	void test_projection() {
		var result = service.findDtoByRegion("East");
		
		for(var dto : result) {
			System.out.println("%d: %s %s".formatted(dto.getId(), dto.getRegion(), dto.getName()));
		}
	}

}
