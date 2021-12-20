package com.jdc.mappings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("multi")
public class MultiActionController {

	/**
	 * multi
	 */
	@RequestMapping
	public void index() {
		
	}
	
	/**
	 * multi/action1
	 */
	@GetMapping("action1")
	public String action1(ModelMap model) {
		model.put("message", "Action 1");
		return "multi";
	}
	
	/**
	 * multi/action1
	 */
	@GetMapping(value = "action1", params = "id")
	public String action1WithParam(ModelMap model) {
		model.put("message", "Action 1 with id Parameter");
		return "multi";
	}
	
	/**
	 * multi/action2
	 */
	@RequestMapping("action2")
	public String action2(ModelMap model) {
		model.put("message", "Action 2");
		return "multi";
	}
	
	/**
	 * multi/**
	 */
	@RequestMapping("**")
	public String actionWildCard(ModelMap model) {
		model.put("message", "Wild Card");
		return "multi";
	}
	
	/**
	 * multi/**
	 */
	@RequestMapping("{:\\d+}")
	public String actionDigit(ModelMap model) {
		model.put("message", "Digit");
		return "multi";
	}
}
