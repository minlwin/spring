package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.data.entity.Course;
import com.jdc.spring.data.repo.CourseRepo;

@SpringJUnitConfig(locations = "classpath:/jpa-configuration.xml")
public class CourseRepoXmlTest {
	
	@Autowired
	private CourseRepo repo;

	@ParameterizedTest
	@CsvSource({
		"1,Java Basic,4,300000"
	})
	void test_create(int id, String name, int duration, int fees) {
		
		// Prepare Input Values
		var input = new Course(name, duration, fees);
		
		// Execute Test Method
		var result = repo.save(input);
		
		// Confirm Result
		assertEquals(id, result.getId());
	}
}
