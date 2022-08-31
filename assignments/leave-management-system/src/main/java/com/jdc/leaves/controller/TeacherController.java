package com.jdc.leaves.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.leaves.model.dto.input.TeacherForm;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

	@GetMapping
	public String index(
			@RequestParam Optional<String> name, 
			@RequestParam Optional<String> phone, 
			@RequestParam Optional<String> email,
			ModelMap model) {
		// TODO implement here
		return "teachers";
	}

	@GetMapping("edit")
	public String edit(@RequestParam Optional<Integer> id, ModelMap model) {
		// TODO implement here
		return "teachers-edit";
	}

	@PostMapping
	public String save(TeacherForm form) {
		// TODO implement here
		return "";
	}

}