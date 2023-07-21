package com.jdc.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member/access")
public class MemberAccessController {

	@GetMapping
	String index(ModelMap model) {
		return "access";
	}
}
