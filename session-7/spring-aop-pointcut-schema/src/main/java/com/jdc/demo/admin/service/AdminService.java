package com.jdc.demo.admin.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jdc.demo.HelloEnabled;

@Component
@Qualifier("admin")
public class AdminService implements HelloEnabled{

	@Override
	public void hello(String message) {
		System.out.println("Message from Admin Service is %s.".formatted(message));
	}
	
	public void doSomething() {
		System.out.println("I am doing something");
	}
}
