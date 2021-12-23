package com.jdc.mappings.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mappings.model.dto.Course;


@Service
public class CourseService {
	
	
	private List<Course> repo;
	
	@Autowired
	private CourseCodeGenerator codeGen;
	
	public CourseService() {
		repo = new ArrayList<>();
	}
	
	public int create(Course c) {
		var id = codeGen.next();
		c.setId(id);
		repo.add(c);	
		return id;
	}
	
	public Course findByid(int id) {
		return repo.stream().filter(c -> c.getId() == id)
				.findAny().orElse(null);
	}
	
	public List<Course> getAll() {
		return List.copyOf(repo);
	}
}
