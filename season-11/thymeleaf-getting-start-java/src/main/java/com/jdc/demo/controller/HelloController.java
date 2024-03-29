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
		
		model.put("title", "Hello Java Config Thymeleaf");
		model.put("list", List.of(
				"Java Based Config",
				"Spring MVC",
				"Thymeleaf View"
				));
		return "hello";
	}
}
