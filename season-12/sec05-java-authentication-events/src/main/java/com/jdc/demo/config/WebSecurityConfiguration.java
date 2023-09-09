package com.jdc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

	@Bean
	UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.builder().username("minlwin").password("{noop}minlwin").authorities("Member").build());
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

		security.authorizeHttpRequests(request -> {
			request.requestMatchers("/", "/home").permitAll();
			request.requestMatchers("/admin/**").hasAuthority("Admin");
			request.requestMatchers("/member/**").hasAuthority("Member");
			request.requestMatchers(HttpMethod.GET, "/member/**").hasAuthority("Admin");
			request.anyRequest().fullyAuthenticated();
		});

		security.formLogin(config -> {});

		return security.build();
	}
}
