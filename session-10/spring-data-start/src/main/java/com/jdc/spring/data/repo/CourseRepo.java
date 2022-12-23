package com.jdc.spring.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.spring.data.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

}
