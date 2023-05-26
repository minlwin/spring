package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.ExpressionDemoConfig;

@SpringJUnitConfig(classes = ExpressionDemoConfig.class)
public class ValueExpressionTest {

	@Value("#{'Hello Spring EL'}")
	String hello;
	
	@Value("#{'Levi''s Jeans'}")
	String helloEscape;
	
	@Value("#{new int[] {1, 2, 3}}")
	int myArray[];
	
	@Value("#{{'Hello', 'Spring', 'Expression Language'}}")
	List<String> list;
	
	@Value("#{{'One': 'Message One', 'Two': 'Message Two'}}")
	Map<String, String> map;
	
	@Value("#{new java.util.Date()}")
	Date now;
	
	@Test
	void demo() {
		assertEquals("Hello Spring EL", hello);
		assertEquals("Levi's Jeans", helloEscape);
		assertEquals(3, myArray.length);
		assertEquals(3, list.size());
		assertEquals(2, map.size());
		assertNotNull(now);
	}
}
