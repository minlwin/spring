package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.ExpressionDemoConfig;

@SpringJUnitConfig(classes = ExpressionDemoConfig.class)
public class OperatorsTest {

	@Value("#{10 gt 11}")
	boolean result_01;
	
	@Value("#{10 le 11}")
	boolean result_02;
	
	@Value("#{10 + 5}")
	int value_01;
	
	@Value("#{systemProperties['user.images'] ?: '/usr/local/images'}")
	String folder;
	
	
	@Test
	void test() {
		assertFalse(result_01);
		assertTrue(result_02);
		
		assertEquals(15, value_01);
		
		assertEquals("/usr/local/images", folder);
	}
}
