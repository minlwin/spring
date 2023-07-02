package com.jdc.spring.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.spring.demo.service.AddressService;
import com.jdc.spring.demo.service.dto.AddressDto;

@Controller
@RequestMapping("customer/address/edit")
public class CustomerAddressEditController {

	@Autowired
	private AddressService service;
	
	@GetMapping
	String edit() {
		return "address-edit";
	}
	
	@PostMapping
	String save(@Validated @ModelAttribute("form") AddressDto form, BindingResult result) {
		
		if(result.hasErrors()) {
			return "address-edit";
		}
		
		service.save(form);
		
		return "redirect:/customer";
	}
	
	@ModelAttribute("form")
	AddressDto form(@RequestParam Optional<Integer> id) {
		
		if(id.isPresent()) {
			return service.findById(id.get());
		}
		
		return new AddressDto();
	}
}
