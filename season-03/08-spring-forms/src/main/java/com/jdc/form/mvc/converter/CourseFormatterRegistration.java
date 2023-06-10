package com.jdc.form.mvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;

@Configuration
public class CourseFormatterRegistration {
	
	@Autowired
	private CourseFormatter formatter;

	@Autowired
	void addConverter(FormatterRegistry registory) {
		registory.addFormatter(formatter);
	}

}
