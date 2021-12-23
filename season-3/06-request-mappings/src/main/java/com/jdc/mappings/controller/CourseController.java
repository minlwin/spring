package com.jdc.mappings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("course")
public class CourseController {
	

	@GetMapping
	public ModelAndView index() {	
		var modelAndView = new ModelAndView();
		modelAndView.setViewName("course-list");
		return modelAndView;
	}

}
