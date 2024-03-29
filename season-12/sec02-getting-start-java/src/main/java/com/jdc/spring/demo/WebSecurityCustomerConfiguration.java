package com.jdc.spring.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

import com.jdc.spring.demo.service.security.CustomerUserDetailsService;

@Configuration
public class WebSecurityCustomerConfiguration {

	
	@Bean
	SecurityFilterChain httpFilter(HttpSecurity http, PersistentTokenBasedRememberMeServices rememberMeServices) throws Exception {
		
		http.authorizeHttpRequests(request -> {
				request.requestMatchers("/authentication", "/signup").permitAll();
				request.requestMatchers("/customer/**").hasAuthority("Customer");
				request.anyRequest().denyAll();
			});
		
		http.formLogin(form -> {
			form.loginPage("/authentication");
			form.defaultSuccessUrl("/customer");
		});
		
		http.rememberMe(rememberMe -> {
			rememberMe.rememberMeServices(rememberMeServices);
		});
		
		http.logout(logout -> logout.logoutSuccessUrl("/"));
		
		return http.build();
	}
	
	@Bean
	PersistentTokenBasedRememberMeServices rememberMeServices(CustomerUserDetailsService userDetailsService) {
		return new PersistentTokenBasedRememberMeServices("SGVsbG8gSmF2YQ==", userDetailsService, new InMemoryTokenRepositoryImpl());
	}
	
	@Bean(name = "authenticationManager")
	AuthenticationManager configure(HttpSecurity http, PasswordEncoder passwordEncoder, CustomerUserDetailsService customerUserDetailsService) throws Exception {

		var builder = http.getSharedObject(AuthenticationManagerBuilder.class);
		
		// Add Authentication Provider with custom user details service
		builder.authenticationProvider(getCustomerProvider(passwordEncoder, customerUserDetailsService));
		
		return builder.build();
	}
	
	@Bean
	SecurityContextRepository securityContextRepository() {
		return new HttpSessionSecurityContextRepository();
	}
	

	private AuthenticationProvider getCustomerProvider(PasswordEncoder passwordEncoder, CustomerUserDetailsService customerUserDetailsService) {
		
		var provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(customerUserDetailsService);
		
		return provider;
	}
	
}
