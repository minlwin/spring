package com.jdc.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.AppConfig;
import com.jdc.demo.admin.dao.AdminDao;

@SpringJUnitConfig(classes = AppConfig.class)
public class PointCutDemoTest {
	
	@Autowired
	AdminDao dao;

	@Test
	void test() {
		dao.searchSomething();
	}
}
