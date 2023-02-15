package com.jdc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	String index() {
		return "home";
	}
	
	@GetMapping("dates")
	String dateTime() {
		return "dates";
	}
	
	@GetMapping("data-types")
	String dataTypes() {
		return "data-types";
	}
	
	@GetMapping("collections")
	String collections() {
		return "collections";
	}
	
	@GetMapping("others")
	String otherUtils() {
		return "others";
	}
}
