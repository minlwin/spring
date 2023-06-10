package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.member.service.MemberService;

@SpringJUnitConfig(value = AppConfig.class)
public class PointCutConfigDemo {

	@Autowired
	private MemberService service;
	
	@Test
	void test() {
		service.hello("Hello AOP");;
	}
}
