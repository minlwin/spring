package com.jdc.form.converter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jdc.form.model.dto.Course;
import com.jdc.form.model.service.CourseRepository;

@Component("courseFormatter")
public class CourseFormatter implements Formatter<Course> {

	@Autowired
	private CourseRepository repo;
	
	@Override
	public String print(Course object, Locale locale) {
		
		if(null != object) {
			return object.getName();
		}
		return null;
	}

	@Override
	public Course parse(String value, Locale locale) throws ParseException {
		if(StringUtils.hasLength(value)) {
			var id = Integer.parseInt(value);
			return repo.findByid(id);
		}
		return null;
	}

}
