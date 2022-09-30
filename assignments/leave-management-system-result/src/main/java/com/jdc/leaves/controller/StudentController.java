package com.jdc.leaves.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.leaves.model.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public String index(
			@RequestParam Optional<String> name, 
			@RequestParam Optional<String> phone, 
			@RequestParam Optional<String> email,
			ModelMap model) {
		model.put("list", service.search(name, phone, email));
		return "students";
	}

}