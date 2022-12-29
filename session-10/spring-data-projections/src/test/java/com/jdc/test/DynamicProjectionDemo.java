package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.dto.StateDtoInf;
import com.jdc.location.model.entity.State;
import com.jdc.location.model.record.StateRecord;
import com.jdc.location.model.repo.StateRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
public class DynamicProjectionDemo {

	@Autowired
	private StateRepo repo;
	
	@Test
	void test_entity() {
		var result = repo.findOneById(1, State.class);
		System.out.println(result.getName());
	}

	@Test
	void test_interface() {
		var result = repo.findOneById(1, StateDtoInf.class);
		System.out.println(result.getName());
	}
	
	@Test
	void test_record() {
		var result = repo.findOneById(1, StateRecord.class);
		System.out.println(result);
	}
}
