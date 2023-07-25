package com.jdc.spring.demo.security;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationEventsHandler {

	@EventListener
	public void handle(AbstractAuthenticationEvent event) {
		System.out.println(event.getClass().getSimpleName());
	}
}
