package com.jdc.demo.security;

import java.io.IOException;

import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	private String failureUrl;
	private String defaultErrorMessage;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		var message = defaultErrorMessage;
		
		if(exception instanceof UsernameNotFoundException) {
			message = "Please check  your login id.";
		} else if (exception instanceof BadCredentialsException) {
			message = "Please check  your password.";
		} else if (exception instanceof AccountStatusException) {
			message = "Please check  your account validity.";
		}
		
		getRedirectStrategy().sendRedirect(request, response, "%s?error=%s".formatted(failureUrl, message));
		
	}
	
	public void setFailureUrl(String failureUrl) {
		this.failureUrl = failureUrl;
	}
	
	public void setDefaultErrorMessage(String defaultErrorMessage) {
		this.defaultErrorMessage = defaultErrorMessage;
	}
}
