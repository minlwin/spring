package com.jdc.demo;

import org.springframework.stereotype.Component;

@Component
public class MyService {

	public void hello() {
		System.out.println("Hello from Spring Bean");
	}
}
