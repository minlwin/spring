package com.jdc.demo.service;

import org.springframework.stereotype.Component;

import com.jdc.demo.dto.Result;

@Component
public class MyService {

	public Result hello(String name, int count) {
		System.out.println("Hello from MyService");
		return new Result(name, count);
	}	
	
	public int divided(int a, int b) {
		return a / b;
	}
}
