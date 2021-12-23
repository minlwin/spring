package com.jdc.mappings.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mappings.model.dto.Course;
import com.jdc.mappings.model.dto.Level;

@Service
public class CourseService {

	private List<Course> repo;

	@Autowired
	private CourseCodeGenerator codeGen;

	public CourseService() {
		repo = new ArrayList<>();
	}
	
	@PostConstruct
	public void init() {
		create(new Course("Java Basic", Level.Basic, 4,180000));
		create(new Course("Spring Web", Level.Intermediate, 4,300000));
		create(new Course("Flutter", Level.Basic, 4,200000));
		create(new Course("Spring Cloud", Level.Advance, 4,300000));
	}

	public int create(Course c) {
		var id = codeGen.next();
		c.setId(id);
		repo.add(c);
		return id;
	}

	public Course findByid(int id) {
		return repo.stream().filter(c -> c.getId() == id).findAny().orElse(null);
	}

	public List<Course> getAll() {
		return List.copyOf(repo);
	}
}
