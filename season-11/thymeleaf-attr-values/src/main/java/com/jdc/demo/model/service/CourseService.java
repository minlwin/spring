package com.jdc.demo.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.demo.model.entity.Course;
import com.jdc.demo.model.entity.Course.Level;
import com.jdc.demo.model.repo.CourseRepo;

@Service
@Transactional(readOnly = true)
public class CourseService {

	@Autowired
	private CourseRepo repo;

	public List<Course> search(Optional<Level> level, Optional<String> name) {
		
		Specification<Course> whichLevel = level.isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.equal(root.get("level"), level.get());
			
		Specification<Course> whichName = name.filter(StringUtils::hasLength).isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.like(cb.lower(root.get("name")), name.get().toLowerCase().concat("%"));
			
		return repo.findAll(whichLevel.and(whichName));
	}
	
	public Course findById(int id) {
		return repo.findById(id).orElseThrow();
	}

	@Transactional
	public void save(Course course) {
		repo.save(course);
	}
}
