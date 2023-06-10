package com.jdc.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ConversionDemo {

	@Test
	void test() {
		
		var parser = new SpelExpressionParser();
		
		var expression = parser.parseExpression("'110'");
		
		var result = expression.getValue(Integer.class);
		
		assertEquals(110, result);
	}
}
