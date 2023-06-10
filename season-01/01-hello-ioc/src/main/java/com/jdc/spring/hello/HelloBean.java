package com.jdc.spring.hello;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HelloBean {

	private String message;
	
	public HelloBean() {
	}
	
	public HelloBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
