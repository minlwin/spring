package com.jdc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.model.service.StateService;

@Controller
@RequestMapping("states")
public class StateController {
	
	@Autowired
	private StateService service;

	@GetMapping
	String index(ModelMap model) {
		model.put("list", service.findAll());
		return "states";
	}
}
