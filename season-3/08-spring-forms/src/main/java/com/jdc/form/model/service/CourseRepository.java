package com.jdc.form.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.jdc.form.model.dto.Course;

@Service
@ApplicationScope
public class CourseRepository {

	private List<Course> courses = List.of(
			new Course(1, "Java Basic", 15000),
			new Course(2, "Spring Angular", 30000),
			new Course(3, "One Stop", 60000),
			new Course(4, "Flutter", 20000)
	);
	
	public List<Course> getCourses() {
		return courses;
	}

	public Course findByid(int id) {
		return courses.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
	}
}
