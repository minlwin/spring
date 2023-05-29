package com.jdc.demo.test.parser.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserContextConfig {

	@Bean
	User defaultUser() {
		return new User("Min Lwin", 48);
	}
}
