package com.jdc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("forbidden")
public class AccessDeniedHandler {

	@GetMapping
	public String index(ModelMap model) {
		model.put("title", "Forbidden");
		model.put("message", "You have no authority to use this action.");
		return "home";
	}
}
