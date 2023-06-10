package com.jdc.demo.test.parser.context;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = ParserContextConfig.class)
public class ParserContextDemoTest {

	@Value("Hello! I am #{@defaultUser.name()} and #{@defaultUser.age()} years old.")
	String message;
	
	@Test
	void test() {
		System.out.println(message);
	}
}
