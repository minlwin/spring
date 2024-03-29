package com.jdc.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.AdditionalService;
import com.jdc.demo.MyService;

@SpringJUnitConfig(classes = AppConfig.class)
public class AopIntroductionTest {

	@Autowired
	private MyService service;
	
	@Test
	void test() {
		service.hello();
		
		if(service instanceof AdditionalService additional) {
			additional.additionalWork();
		}
	}
}
