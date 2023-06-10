package com.jdc.demo.service;

import org.springframework.stereotype.Component;

import com.jdc.demo.dto.Student;

@Component
public class DemoService {

	public void doBusiness(String ... names) {
		System.out.println("This is a void method without arguments.");
	}
	
	public Student getStudent() {
		return new Student(1, "Min Lwin", "09782003098", "minlwin@gmail.com");
	}
	
	public int divided(int a, int b) {
		return a / b;
	}
}
