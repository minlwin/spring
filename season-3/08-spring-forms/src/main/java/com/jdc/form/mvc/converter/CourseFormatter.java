package com.jdc.form.mvc.converter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jdc.form.root.dto.Course;
import com.jdc.form.root.service.CourseRepository;

@Component("courseFormatter")
public class CourseFormatter implements Formatter<Course> {

	@Autowired
	private CourseRepository repo;
	
	@Override
	public String print(Course object, Locale locale) {
		return Optional.ofNullable(object).map(Course::getName).orElse("");
	}

	@Override
	public Course parse(String value, Locale locale) throws ParseException {
		return Optional.ofNullable(value).filter(StringUtils::hasLength)
				.map(Integer::parseInt).map(repo::findByid).orElse(null);
	}
}
