package com.jdc.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

	@GetMapping
	public String hello(ModelMap model) {
		
		model.put("title", "Hello Thymeleaf View");
		
		model.put("list", List.of(
				"Java Web",
				"Jakarta Servlet",
				"Spring MVC",
				"Thymeleaf Template Engine"
				));
		
		return "hello";
	}
}
