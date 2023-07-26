package com.jdc.demo.security;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventsHandler {

	@EventListener
	public void handle(AbstractAuthenticationEvent e) {
		System.out.println(e.getClass().getName());
	}
}
