package com.jdc.scope.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.jdc.scope.model.Counter;

@Configuration
@ComponentScan("com.jdc.scope.model")
public class RootConfig {

	@Bean
	@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
	Counter requestCounter() {
		return new Counter();
	}
	
	@Bean
	@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	Counter sessionCounter() {
		return new Counter();
	}

	@Bean
	@Scope(scopeName = "application", proxyMode = ScopedProxyMode.TARGET_CLASS)
	Counter applicationCounter() {
		return new Counter();
	}

}
