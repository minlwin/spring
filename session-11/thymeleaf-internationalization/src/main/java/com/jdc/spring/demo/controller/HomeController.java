package com.jdc.spring.demo.controller;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@GetMapping
	String index() {
		
		System.out.println(LocaleContextHolder.getLocale());
		
		return "home";
	}
}
