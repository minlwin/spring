package com.jdc.leaves.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.leaves.model.dto.input.ClassForm;
import com.jdc.leaves.model.dto.input.RegistrationForm;

@Controller
@RequestMapping("/classes")
public class ClassController {

	@GetMapping
	public String index(
			@RequestParam Optional<String> teacher, 
			@RequestParam Optional<LocalDate> from, 
			@RequestParam Optional<LocalDate> to,
			ModelMap model) {
		// TODO implement here
		return "";
	}

	@GetMapping("edit")
	public String edit(@RequestParam Optional<Integer> id, ModelMap model) {
		// TODO implement here
		return "";
	}

	@PostMapping
	public String save(ClassForm form) {
		// TODO implement here
		return "";
	}

	@GetMapping("{id}")
	public String showDetails(@PathVariable int id, ModelMap model) {
		// TODO implement here
		return "";
	}

	@GetMapping("registration/{id}")
	public String register(@PathVariable int id, ModelMap model) {
		// TODO implement here
		return "";
	}

	
	@PostMapping
	public String saveRegistration(RegistrationForm form) {
		// TODO implement here
		return "";
	}

	@GetMapping("registration/details/{id}")
	public String showRegistrationDetails(@PathVariable int id, ModelMap model) {
		// TODO implement here
		return "";
	}

}