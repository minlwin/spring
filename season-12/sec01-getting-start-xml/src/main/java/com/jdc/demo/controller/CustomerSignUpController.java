package com.jdc.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.service.CustomerService;
import com.jdc.demo.service.dto.SignUpForm;
import com.jdc.demo.service.exceptions.BusinessException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("signup")
public class CustomerSignUpController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SecurityContextRepository securityContextRepository;
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	@GetMapping
	String index() {
		return "signup";
	}
	
	@PostMapping
	String signUp(
			@Validated @ModelAttribute("form") SignUpForm form, 
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		
		if(result.hasErrors()) {
			return "signup";
		}
		
		try {
			// Create Customer
			customerService.create(form);
			
			// Authenticate
			var authentication = authenticationManager.authenticate(form.authentication()); 
			
			// Set Authentication Result to Security Context
			var securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			
			// Save Security Context to SecurityContextRepository
			securityContextRepository.saveContext(securityContext, request, response);
			
			// Get Saved Request to redirect
			var redirectUrl = getSavedRequest(request, response).map(SavedRequest::getRedirectUrl)
					.orElse("/customer");
			
			return "redirect:%s".formatted(redirectUrl);
	
		} catch (BusinessException e) {
			result.rejectValue("email", "email", e.getMessage());
			return "signup";
		}
	}
	
	@ModelAttribute("form")
	SignUpForm form() {
		return new SignUpForm();
	}
	
	private Optional<SavedRequest> getSavedRequest(HttpServletRequest request, HttpServletResponse response) {
		var savedRequest = requestCache.getRequest(request, response);
		return Optional.ofNullable(savedRequest);
	}
}
