package com.jdc.mappings.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.mappings.model.dto.Level;

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
	
	@GetMapping("{date:\\d{4}\\-\\d{2}\\-\\d{2}}")
	public String dateInput(
			@PathVariable 
			@DateTimeFormat(pattern = "yyyy-MM-dd") 
			LocalDate date,
			Model model
			) {
		
		model.addAttribute("date", date);
		
		return "inputs";
	}
	
	@GetMapping("{level:Basic|Intermediate|Advance}")
	public String useEnum(@PathVariable Level level, Model model) {
		
		model.addAttribute("date", level);
		return "inputs";
	}

	@GetMapping("matrix/{product}")
	public String userMatrix(
			@PathVariable String product,
			@MatrixVariable(name = "s", pathVar = "product") String size,
			@MatrixVariable(value= "c", required = false, defaultValue = "1") int count,
			Model model
			) {
		
		var message = "Product: %s, Size: %s, Count: %d".formatted(
				product, size, count);
		
		model.addAttribute("date", message);
		
		return "inputs";
	}
	
	@GetMapping("request")
	public String useRequestParameter(
			Model model,
			@RequestParam("p") String product,
			@RequestParam(name = "w", required = false, defaultValue = "30") int width,
			@RequestParam(value = "l", required = false, defaultValue = "30") int length
			) {
		var message = "Product: %s, Width: %d, Length: %d".formatted(
				product, width, length);
		
		model.addAttribute("date", message);
		
		return "inputs";
	}
}
