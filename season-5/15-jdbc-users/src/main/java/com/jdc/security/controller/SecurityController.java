package com.jdc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

	@PostMapping("signup")
	public String signUp() {
		return "redirect:/member/home";
	}
}
