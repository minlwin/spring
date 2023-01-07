package com.jdc.location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.location.model.service.StateSpecService;

@SpringBootTest
public class StateDeleteTest {

	@Autowired
	private StateSpecService service;
	
	@Test
	void test_spec_delete() {
		var count = service.deleteByRegion("East");
		assertThat(count, is(2L));
	}
}
