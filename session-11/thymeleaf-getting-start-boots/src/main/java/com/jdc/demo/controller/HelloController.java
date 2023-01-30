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
	String hello(ModelMap model) {
		
		model.put("title", "Thymeleaf with Spring Boots");
		
		model.put("list", List.of(
				"Spring Boots",
				"Spring Web MVC",
				"Thymeleaf View"
				));
		
		return "hello";
	}
	
	@GetMapping("html5")
	String htmlStyle(ModelMap model) {
		
		model.put("title", "Thymeleaf with Spring Boots");
		
		model.put("list", List.of(
				"Spring Boots",
				"Spring Web MVC",
				"Thymeleaf View"
				));
		
		return "data-attr";
	}
}
