package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.repo.StateRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class NullableParamTest {

	@Autowired
	private StateRepo repo;
	
	@Test
	void test_find_by_name_with_null_value() {
		assertThrows(IllegalArgumentException.class, 
				() -> repo.findOneByName(null));
	}
}
