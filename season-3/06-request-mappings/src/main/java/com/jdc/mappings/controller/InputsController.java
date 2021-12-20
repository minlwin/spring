package com.jdc.mappings.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("inputs")
public class InputsController {
	
	@GetMapping
	public void index() {
	}
	
	// inputs/?/search
	@GetMapping("{type}/search/{id:\\d+}")
	public String findByType(
			@PathVariable String type,
			@PathVariable Integer id,
			Model model) {
		
		model.addAttribute("type", type);
		model.addAttribute("id", id);
		
		return "inputs";
	}
	
	@GetMapping("{date}")
	public String dateInput(
			@PathVariable 
			@DateTimeFormat(pattern = "yyyy-MM-dd") 
			LocalDate date,
			Model model
			) {
		
		model.addAttribute("date", date);
		
		return "inputs";
	}
	
	@GetMapping("enum/{level}")
	public String useEnum(@PathVariable Level level, Model model) {
		
		model.addAttribute("date", level);
		return "inputs";
	}
}
