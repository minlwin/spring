package com.jdc.spring.demo;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

	@Bean
	SecurityFilterChain homeFilter(HttpSecurity http) throws Exception {
		http.securityMatcher("/")
			.authorizeHttpRequests(request -> {
				request.anyRequest().permitAll();
			});
		return http.build();
	}
	
	@Bean
	SecurityFilterChain resourcesFilter(HttpSecurity http) throws Exception {
		http.securityMatcher("/resources/**")
			.authorizeHttpRequests(request -> {
				request.anyRequest().permitAll();
			});
		return http.build();
	}
	
	@Bean
	SecurityFilterChain httpFilter(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(request -> {
				request.requestMatchers("/admin/**").hasAuthority("Admin");
				request.requestMatchers("/member/**").hasAnyAuthority("Admin", "Member");
				request.anyRequest().denyAll();
			});
		
		http.formLogin(Customizer.withDefaults());
		
		http.logout(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	InMemoryUserDetailsManager userDetailsManager() {
		return new InMemoryUserDetailsManager(List.of(
			User.withUsername("admin@gmail.com").password("{noop}admin").authorities("Admin").build(),
			User.withUsername("member@gmail.com").password("{noop}member").authorities("Member").build()	
				));
	}
	
}
