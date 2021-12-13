package com.jdc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.spring.hello.HelloBean;

class HelloTest {
	
	@Test
	void test() {
		
		// Initialize IoC Container that's using xml base configuration
		try(var context = new GenericXmlApplicationContext("/application.xml")) {
			
			// get bean by default constructor
			var bean1 = context.getBean(HelloBean.class);
			
			assertNotNull(bean1);
			
			// get bean by constructor with arguments
			var bean2 = context.getBean(HelloBean.class, "Hello Constructor Argument");
			
			assertNotNull(bean2);
			
			assertEquals("Hello Constructor Argument", bean2.getMessage());
		}		
		
	}

}
