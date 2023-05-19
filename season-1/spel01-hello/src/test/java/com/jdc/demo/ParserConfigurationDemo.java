package com.jdc.demo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ParserConfigurationDemo {

	@Test
	void test_without_configuration() {
		
		assertThrows(SpelEvaluationException.class, () -> {
			var root = new MyData();
			
			var parser = new SpelExpressionParser();
			
			var expresion = parser.parseExpression("list[0] = 'Hello SpEL'");
			expresion.getValue(root);
		});
	}
	
	@Test
	void test_with_configuration() {
		assertDoesNotThrow(() -> {
			
			var config = new SpelParserConfiguration(true, true);
			
			var parser = new SpelExpressionParser(config);
			
			var expresion = parser.parseExpression("list[0] = 'Hello SpEL'");

			var root = new MyData();
			expresion.getValue(root);
			
			assertEquals(1, root.getList().size());
			assertEquals("Hello SpEL", root.getList().get(0));
		});
	}
}
