package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.repo.StateRecordRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class ClassBasedProjection {

	@Autowired
	private StateRecordRepo repo;
	
	@Test
	void test() {
		var result = repo.findOneById(1);
		
		assertNotNull(result);
		System.out.println(result);
		
		System.out.println(result.displayName());
	}
}
