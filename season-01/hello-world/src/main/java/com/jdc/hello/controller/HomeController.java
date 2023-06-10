package com.jdc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.hello.model.StateRepo;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private StateRepo repo;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("title", "Hello Spring MVC");
		model.addAttribute("states", repo.findAll());
		return "index";
	}
}
