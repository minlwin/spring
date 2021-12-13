package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.spring.locations.model.dao.StateDao;

class LazyInitModeTest {

	@Test
	void test() {
		
		try(var context = new GenericXmlApplicationContext("/application.xml")) {
			context.getBean(StateDao.class);
			context.getBean(StateDao.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
