package com.jdc.leaves.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@GetMapping
	public String index(
			@RequestParam Optional<String> name, 
			@RequestParam Optional<String> phone, 
			@RequestParam Optional<String> email,
			ModelMap model) {
		// TODO implement here
		return "students";
	}

}