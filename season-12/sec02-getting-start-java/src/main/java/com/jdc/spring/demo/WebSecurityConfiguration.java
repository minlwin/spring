package com.jdc.spring.demo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	
	@Autowired
	private DataSource dataSource;

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
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager configure(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
		var builder = http.getSharedObject(AuthenticationManagerBuilder.class);
		
		// Add Authentication Provider with InMemoryUserDetailsManager
		builder.authenticationProvider(getAdminUserProvider(passwordEncoder));
		
		// Add Authentication Provider with JdbcUserDetailsManager
		builder.authenticationProvider(getMemberProvider(passwordEncoder));
		
		return builder.build();
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
	
	private AuthenticationProvider getMemberProvider(PasswordEncoder passwordEncoder) {
		
		var userDetailsService = new JdbcUserDetailsManager(dataSource);
		userDetailsService.setUsersByUsernameQuery("select email username, password, true from MEMBERS where email = ?");
		userDetailsService.setAuthoritiesByUsernameQuery("select email username, role from MEMBERS where email = ?");
		var provider = new DaoAuthenticationProvider(passwordEncoder);
		provider.setUserDetailsService(userDetailsService);
		
		return provider;
	}
	
}
