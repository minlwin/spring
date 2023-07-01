package com.jdc.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.service.AddressService;


@Controller
@RequestMapping("customer")
public class CustomerHomeController {
	
	@Autowired
	private AddressService service;

	@GetMapping
	public String index(Principal principal, ModelMap model) {
		
		if(principal instanceof UsernamePasswordAuthenticationToken token) {
			model.put("loginUser", token.getName());
			model.put("authorities", token.getAuthorities()
					.stream().map(a -> a.getAuthority()).toList());
		}
		
		model.put("addresses", service.findOwnAddress());
		
		return "customer";
	}
}
