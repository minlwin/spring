package com.jdc.mappings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping(
			path = {"/", "/hello", "/home"})
	public String index() {
		return "home";
	}
}
