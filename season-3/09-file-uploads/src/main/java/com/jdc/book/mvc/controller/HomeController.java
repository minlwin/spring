package com.jdc.book.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({
	"/home", "/book"
})
public class HomeController {

	
	@GetMapping
	String indes() {
		return "home";
	}
	
	@GetMapping("edit")
	String edit() {
		return "book-edit";
	}
}
