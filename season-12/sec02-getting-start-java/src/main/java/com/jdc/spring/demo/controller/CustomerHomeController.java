package com.jdc.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.spring.demo.service.AddressService;

@Controller
@RequestMapping("customer")
public class CustomerHomeController {
	
	@Autowired
	private AddressService service;

	@GetMapping
	String index(Authentication authentication, ModelMap model) {
		
		model.put("loginId", authentication.getName());
		model.put("authorities", authentication.getAuthorities()
				.stream().map(a -> a.getAuthority()).toList());
		
		model.put("addresses", service.findOwnAddress());
		
		return "customer";
	}
}
