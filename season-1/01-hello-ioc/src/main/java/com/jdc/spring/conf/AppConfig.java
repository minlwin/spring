package com.jdc.spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.jdc.spring.hello.HelloBean;

@Configuration
public class AppConfig {

	@Bean
	@Scope("prototype")
	public HelloBean helloBean() {
		return new HelloBean();
	}

	@Bean
	@Scope("prototype")
	public HelloBean helloBeanWithArgs(String message) {
		return new HelloBean(message);
	}
}
