package com.jdc.leaves.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.leaves.model.dto.input.TeacherForm;
import com.jdc.leaves.model.dto.output.TeacherListVO;
import com.jdc.leaves.model.service.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService service;

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
	public String save(@ModelAttribute(name = "form") TeacherForm form) {
		// TODO implement here
		return "redirect:/teachers";
	}
	
	@ModelAttribute(name = "form")
	TeacherForm form(@RequestParam Optional<Integer> id)  {
		return id.map(service::findById)
				.map(TeacherListVO::form)
				.orElse(new TeacherForm());
	}

}