package com.jdc.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdc.demo.dto.Classes;
import com.jdc.demo.dto.Registration;
import com.jdc.demo.dto.Student;
import com.jdc.demo.repo.RegistrationRepo;
import com.jdc.demo.repo.StudentRepo;

@Repository
public class RegistrationService {
	
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private RegistrationRepo registrationRepo;
	
	public Registration register(Classes classes, Student student, LocalDate date) {
			
		// create student
		var registStudent = studentRepo.create(student);
		
		// create registration
		return registrationRepo.create(new Registration(0, classes, registStudent, date));
	}

	public void sayHello() {
		System.out.println("Hello");
	}
	
}
