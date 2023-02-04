package com.jdc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.LazyContextVariable;

import com.jdc.demo.model.entity.State;
import com.jdc.demo.model.service.StateService;

@Controller
@RequestMapping("states")
public class StateController {
	
	@Autowired
	private StateService service;

	@GetMapping
	String index(ModelMap model) {
		model.put("size", service.getAllCount());
		
		model.put("list", new LazyContextVariable<List<State>>() {

			@Override
			protected List<State> loadValue() {
				return service.findAll();
			}
		});
		return "states";
	}
	
	@PostMapping
	String upload(@RequestParam MultipartFile file) {
		service.upload(file);
		return "redirect:/states";
	}
}
