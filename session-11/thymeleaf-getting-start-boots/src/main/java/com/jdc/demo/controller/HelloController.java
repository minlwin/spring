package com.jdc.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.dto.Account;
import com.jdc.demo.dto.Contact;

@Controller
@RequestMapping("/")
public class HelloController {

	@GetMapping
	String hello(ModelMap model) {
		
		model.put("title", "Thymeleaf with Spring Boots");
		
		model.put("list", List.of(
				"Spring Boots",
				"Spring Web MVC",
				"Thymeleaf View"
				));
		
		return "hello";
	}
	
	@GetMapping("html5")
	String htmlStyle(ModelMap model) {
		
		model.put("title", "Thymeleaf with Spring Boots");
		
		model.put("list", List.of(
				"Spring Boots",
				"Spring Web MVC",
				"Thymeleaf View"
				));
		
		return "data-attr";
	}
	
	@GetMapping("out-text") 
	String outputText(ModelMap model) {
		model.put("message", "<b>This is output demo</b>");
		return "outputs";
	}
	
	@GetMapping("literals")
	String usingLiterals(ModelMap model) {
		model.put("message", "Message from Controller.");
		return "literals";
	}
	
	@GetMapping("objects")
	String usingObjects(ModelMap model) {
		model.put("account", new Account(1, "Aung Aung", new Contact("091818171", "aung@gmail.com")));
		return "objects";
	}

}
