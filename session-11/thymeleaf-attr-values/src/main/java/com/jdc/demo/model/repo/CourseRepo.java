package com.jdc.demo.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.model.entity.Course;

public interface CourseRepo extends JpaRepositoryImplementation<Course, Integer>{

}
