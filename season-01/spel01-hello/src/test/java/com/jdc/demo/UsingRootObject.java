package com.jdc.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class UsingRootObject {
	
	private ExpressionParser parser;
	
	@BeforeEach
	void init() {
		parser = new SpelExpressionParser();
	}

	@Test
	void using_root_object() {
		
		var student = new Student("Aung Aung", 20, List.of("Java", "Spring", "Angular", "Flutter"));
		
		var expression = parser.parseExpression("name");
		
		var result = expression.getValue(student, String.class);
		assertEquals("Aung Aung", result);
		
		if(expression.isWritable(student)) {
			expression.setValue(student, "Maung Maung");
		}
		
		expression = parser.parseExpression("age");
		var age = expression.getValue(student, Integer.class);
		assertEquals(20, age);
		
		expression = parser.parseExpression("'First Interest is ' + interests[0]");
		var firstInterest = expression.getValue(student, String.class);
		
		assertEquals("First Interest is Java", firstInterest);	
	}
	
	
	@Test
	void using_record_root() {
		Address address = new Address("Yadanarmyaning Street", "No120/4F", "Kamayut");
		
		var expression = parser.parseExpression("street");
		var result = expression.getValue(address, String.class);
		
		if(expression.isWritable(address)) {
			expression.setValue(address, "Thitsar Street");
		}
		
		assertEquals(address.street(), result);
		
		expression = parser.parseExpression("building");
		result = expression.getValue(address, String.class);
		
		assertEquals(address.building(), result);
	}
	
}
