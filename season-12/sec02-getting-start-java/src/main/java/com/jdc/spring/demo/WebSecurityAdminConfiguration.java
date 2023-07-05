package com.jdc.spring.demo;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityAdminConfiguration {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
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
	SecurityFilterChain adminResources(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
		http.securityMatcher("/admin/**")
			.authorizeHttpRequests(request -> {
				request.anyRequest().hasAuthority("Admin");
			});
		
		http.httpBasic(withDefaults());
		
		var authenticationManager = new ProviderManager(getAdminUserProvider(passwordEncoder));
		http.authenticationManager(authenticationManager);
		
		return http.build();
	}
	
	
	private AuthenticationProvider getAdminUserProvider(PasswordEncoder passwordEncoder) {
		var userDetailsService = new InMemoryUserDetailsManager(List.of(
				User.withUsername("admin@gmail.com")
					.password("$2a$10$oXE.lfp2mdzcYBdyZdyHkOI4yK4RvsEVEvm1r9xij8GissVsOpj7S")
					.authorities("Admin").build()));
		var provider = new DaoAuthenticationProvider(passwordEncoder);
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
		
}
