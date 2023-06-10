package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.ExpressionDemoConfig;

@SpringJUnitConfig(classes = ExpressionDemoConfig.class)
public class TypeReferenceTest {

	@Value("#{T(java.lang.Integer).MAX_VALUE}")
	int maxValue;
	
	@Value("#{T(com.jdc.demo.MyFormatter).format(10000)}")
	String formattedValue;
	
	@Test
	void demo() {
		assertEquals(Integer.MAX_VALUE, maxValue);
		assertEquals("10,000", formattedValue);
	}
}
