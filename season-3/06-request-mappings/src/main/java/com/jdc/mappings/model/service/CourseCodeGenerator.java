package com.jdc.mappings.model.service;

import org.springframework.stereotype.Component;

@Component
public class CourseCodeGenerator {

	private int id;

	public int next() {
		return ++id;
	}
}
