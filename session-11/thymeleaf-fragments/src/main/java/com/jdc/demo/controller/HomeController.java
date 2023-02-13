package com.jdc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService service;

	@GetMapping("/")
	String home(ModelMap model) {
		
		model.put("products", service.findAll());
		
		return "home";
	}
}
