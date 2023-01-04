package com.jdc.location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.service.LocationService;

@SpringBootTest
public class LocationServiceTest {

	@Autowired
	private LocationService service;
	
	@Test
	@Transactional
	void test_find_stream() {
		var result = service.findByRegionAsStream("East");
		assertNotNull(result);
		assertEquals(2L, result.count());
	}
	
	@Test
	void test_find_first() {
		var result = service.findFirstByRegion("East");
		assertThat(result.get(), allOf(
			hasProperty("id", is(5)),
			hasProperty("name", is("Kayah"))));
	}
}
