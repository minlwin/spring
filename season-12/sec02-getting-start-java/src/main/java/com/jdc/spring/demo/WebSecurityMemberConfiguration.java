package com.jdc.spring.demo;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
public class WebSecurityMemberConfiguration {

	@Bean
	SecurityFilterChain memberFilter(HttpSecurity http, 
			DigestAuthenticationEntryPoint digestAuthenticationEntryPoint,
			DigestAuthenticationFilter digestAuthenticationFilter) throws Exception {
		
		http.securityMatcher("/member/**")
			.authorizeHttpRequests(request -> request.anyRequest().hasAuthority("Member"));
		
		http.exceptionHandling(exception -> {
			exception.authenticationEntryPoint(digestAuthenticationEntryPoint);
		});
		
		http.addFilterAt(digestAuthenticationFilter, DigestAuthenticationFilter.class);
		
		return http.build();
	}
	
	@Bean
	DigestAuthenticationEntryPoint digestAuthenticationEntryPoint() {
		var bean = new DigestAuthenticationEntryPoint();
		bean.setKey("MY_SECRET_KEY");
		bean.setRealmName("DIGEST_REALM");
		return bean;
	}
	
	@Bean
	DigestAuthenticationFilter digestAuthenticationFilter(
			DigestAuthenticationEntryPoint digestAuthenticationEntryPoint, 
			JdbcUserDetailsManager memberUserDetailsService) {
		var bean = new DigestAuthenticationFilter();
		bean.setAuthenticationEntryPoint(digestAuthenticationEntryPoint);
		bean.setUserDetailsService(memberUserDetailsService);
		bean.setCreateAuthenticatedToken(true);
		return bean;
	}
	
	@Bean
	JdbcUserDetailsManager memberUserDetailsService(DataSource dataSource) {
		
		var userDetailsService = new JdbcUserDetailsManager(dataSource);
		userDetailsService.setUsersByUsernameQuery("select email username, password, true from MEMBERS where email = ?");
		userDetailsService.setAuthoritiesByUsernameQuery("select email username, role from MEMBERS where email = ?");
		
		return userDetailsService;
	}	
}
