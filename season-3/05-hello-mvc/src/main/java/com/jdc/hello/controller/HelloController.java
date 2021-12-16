package com.jdc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.hello.model.HelloService;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	private HelloService service;

	@GetMapping
	public void index(Model model) {
		model.addAttribute("message", service.getMessage());
	}
}
