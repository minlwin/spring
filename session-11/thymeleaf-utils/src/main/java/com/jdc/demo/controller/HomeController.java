package com.jdc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	@GetMapping("objects")
	String objects(ModelMap model) {
		model.put("nullValue", null);
		model.put("notNullValue", "This is not null");
		return "objects";
	}
	
	@GetMapping("bools")
	String bools() {
		return "bools";
	}
	
	@GetMapping("numbers")
	String numbers() {
		return "numbers";
	}
	
	@GetMapping("strings")
	String strings() {
		return "strings";
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
