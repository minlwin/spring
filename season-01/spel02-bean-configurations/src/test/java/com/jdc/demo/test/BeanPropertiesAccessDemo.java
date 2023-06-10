package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.ExpressionDemoConfig;

@SpringJUnitConfig(classes = ExpressionDemoConfig.class)
public class BeanPropertiesAccessDemo {
	
	@Value("#{@member.name}")
	String name;
	
	@Value("#{@member.address.township}")
	String township;
	
	@Value("#{T(com.jdc.demo.NumberGenerator).generate()}")
	int randomNumber;
	
	@Test
	void demo() {
		assertEquals("Aung Aung", name);
		assertEquals("Kamayut", township);
		assertTrue(randomNumber <= 100);
	}

}
