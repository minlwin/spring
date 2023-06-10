package com.jdc.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.service.DemoService;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class DemoServiceTest {

	@Autowired
	private DemoService service;
	
	@Test
	void test() {
		service.divided(10, 0);
	}
}
