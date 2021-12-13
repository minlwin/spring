package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.spring.conf.AppConfig;
import com.jdc.spring.hello.HelloBean;

class AnnotationTest {

	@Test
	void testForDefaultConstructor() {
		try(var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			// Bean initialized by default constructor
			var bean = context.getBean("helloBean", HelloBean.class);
			assertNotNull(bean);
			assertNull(bean.getMessage());
		}

	}
	
	@Test
	void testForConstructorArgument() {
		try(var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			// Bean initialized by constructor with argument
			HelloBean bean = (HelloBean) context.getBean("helloBeanWithArgs", "Hello IoC Container");
			assertNotNull(bean);
			assertEquals("Hello IoC Container", bean.getMessage());
		}		
	}

}
