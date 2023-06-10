package com.jdc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberHomeController {

	@GetMapping
	public String index(ModelMap model) {
		model.put("title", "Member Home");
		model.put("message", "This is message from Member Controller.");
		return "home";
	}
}
