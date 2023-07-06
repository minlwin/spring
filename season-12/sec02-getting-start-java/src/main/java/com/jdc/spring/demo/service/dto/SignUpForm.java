package com.jdc.spring.demo.service.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpForm {

	@NotBlank(message = "Please enter customer name.")
	private String name;

	@Email(message = "Please enter valid email.")
	@NotBlank(message = "Please enter login email.")
	private String email;
	
	@NotBlank(message = "Please enter password.")
	private String password;

	public Authentication authentication() {
		return UsernamePasswordAuthenticationToken.unauthenticated(email, password);
	}
}
