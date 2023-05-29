package com.jdc.demo.test.variables;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class ExpressionVariableTest {

	private ExpressionParser parser;
	
	@BeforeEach
	void init() {
		parser = new SpelExpressionParser();
	}
	
	@Test
	void test_expression_variable() {
		
		var context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		context.setVariable("today", LocalDate.now());
		
		var expression = parser.parseExpression("#today.year");
		
		var result = expression.getValue(context);
		
		assertEquals(LocalDate.now().getYear(), result);
	}
	
	
	@Test
	void test_expression_function() throws NoSuchMethodException, SecurityException {
		var context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		var method = CustomUtil.class.getDeclaredMethod("toUpperCase", String.class);
		
		context.setVariable("upper", method);
		
		var expression = parser.parseExpression("#upper('Hello SpEL')");
		var result = expression.getValue(context);
		
		assertEquals("HELLO SPEL", result);
	}
}
