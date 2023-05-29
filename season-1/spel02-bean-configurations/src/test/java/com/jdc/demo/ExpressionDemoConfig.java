package com.jdc.demo;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.demo.entity.Address;
import com.jdc.demo.entity.Member;

@Configuration
public class ExpressionDemoConfig {

	@Bean
	LocalDate today() {
		return LocalDate.now();
	}
	
	@Bean
	Member member() {
		var address = new Address(1, "No 120", "Yadanar Myaning", "Kamayut");
		return new Member(1, "Aung Aung", address);
	}
}
