package com.jdc.demo.security;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class CustomProviderManager extends ProviderManager{
	
	public CustomProviderManager(
			UserDetailsService userDetailsService, 
			ApplicationEventPublisher applicationEventPublisher) {
		super(new DaoAuthenticationProvider());
		
		for(var provider : getProviders()) {
			if(provider instanceof DaoAuthenticationProvider daoProvider) {
				daoProvider.setUserDetailsService(userDetailsService);
				daoProvider.setHideUserNotFoundExceptions(false);
			}
		}
		
		var publisher = new DefaultAuthenticationEventPublisher(applicationEventPublisher);
		setAuthenticationEventPublisher(publisher);
	}

}
