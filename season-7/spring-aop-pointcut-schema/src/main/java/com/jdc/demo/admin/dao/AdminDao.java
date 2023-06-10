package com.jdc.demo.admin.dao;

import org.springframework.stereotype.Component;

@Component
public class AdminDao {

	public void doSomething() {
		System.out.println("Hello from Admin Do");
	}
	
	public void sayHello(String name) {
		System.out.println("Hello %s".formatted(name));
	}
}
