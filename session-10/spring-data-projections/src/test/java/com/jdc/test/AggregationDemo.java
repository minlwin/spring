package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.repo.StateRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class AggregationDemo {

	@Autowired
	private StateRepo stateRepo;
	
	@Test
	void test() {
		var result = stateRepo.searchStateList("East");
		
		for(var dto : result) {
			dto.show();
		}
	}
}
