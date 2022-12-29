package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.repo.StateNativeSqlRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class ProjectionOfNamedNativeQuery {

	@Autowired
	private StateNativeSqlRepo repo;
	
	@Test
	void test() {
		var result = repo.findById(1);
		System.out.println(result);
	}
}
