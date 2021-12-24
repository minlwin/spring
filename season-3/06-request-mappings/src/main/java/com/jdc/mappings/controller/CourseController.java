package com.jdc.mappings.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.mappings.model.dto.Course;
import com.jdc.mappings.model.dto.Level;
import com.jdc.mappings.model.dto.Result;
import com.jdc.mappings.model.dto.Result.Status;
import com.jdc.mappings.model.service.CourseService;

@Controller
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping
	public Map<String, Object> index() {
		var model = new HashMap<String, Object>();
		model.put("list", service.getAll());
		return model;
	}
	
	@GetMapping("edit")
	public String edit() {
		return "course-edit";
	}
	
	@PostMapping
	public String save(
			@RequestParam String name,
			@RequestParam Level level,
			@RequestParam int duration,
			@RequestParam int fees,
			RedirectAttributes redirect
			) {
		
		var course = new Course(name, level, duration, fees);
		var id = service.create(course);
		redirect.addFlashAttribute("result", new Result(Status.Success, "New course has been created!"));
		return "redirect:/course/%d".formatted(id);
	}
	
	@GetMapping("{id:\\d+}")
	public String findById(@PathVariable int id, ModelMap model) {
		model.put("course", service.findByid(id));
		return "course-details";
	}

}
