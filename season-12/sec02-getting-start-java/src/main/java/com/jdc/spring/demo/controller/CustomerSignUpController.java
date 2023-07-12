package com.jdc.spring.demo.controller;

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

import com.jdc.spring.demo.service.CustomerService;
import com.jdc.spring.demo.service.dto.SignUpForm;

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
			@ModelAttribute("form") @Validated SignUpForm form, BindingResult result, 
			HttpServletRequest request, HttpServletResponse response) {
		
		if(result.hasErrors()) {
			return "signup";
		}
		
		// Create Customer
		customerService.create(form);
		
		// Authenticate
		var authentication = authenticationManager.authenticate(form.authentication());
		
		// Set Authentication Result to Security Context
		var securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);
		
		// Save Security Context to Security Context Repository
		securityContextRepository.saveContext(securityContext, request, response);
		
		// Redirect to Saved Request
		var rediredtUrl = getSavedRequest(request, response)
				.map(SavedRequest::getRedirectUrl).orElse("/customer");
		
		return "redirect:%s".formatted(rediredtUrl);
	}
	
	@ModelAttribute("form")
	SignUpForm form() {
		return new SignUpForm();
	}
	
	private Optional<SavedRequest> getSavedRequest(HttpServletRequest request, HttpServletResponse response) {
		return Optional.ofNullable(requestCache.getRequest(request, response));
	}
}
