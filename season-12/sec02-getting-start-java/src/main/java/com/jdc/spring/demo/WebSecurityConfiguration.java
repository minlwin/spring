package com.jdc.spring.demo;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

import com.jdc.spring.demo.service.security.CustomerUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private CustomerUserDetailsService customerUserDetailsService;

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
	JdbcUserDetailsManager memberUserDetailsService() {
		
		var userDetailsService = new JdbcUserDetailsManager(dataSource);
		userDetailsService.setUsersByUsernameQuery("select email username, password, true from MEMBERS where email = ?");
		userDetailsService.setAuthoritiesByUsernameQuery("select email username, role from MEMBERS where email = ?");
		
		return userDetailsService;
	}	
	
	@Bean
	SecurityFilterChain httpFilter(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(request -> {
				request.requestMatchers("/customer/**").hasAuthority("Customer");
				request.anyRequest().denyAll();
			});
		
		http.formLogin(withDefaults());
		
		http.logout(withDefaults());
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager configure(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
		var builder = http.getSharedObject(AuthenticationManagerBuilder.class);
		
		// Add Authentication Provider with custom user details service
		builder.authenticationProvider(getCustomerProvider(passwordEncoder));
		
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
	

	
	private AuthenticationProvider getCustomerProvider(PasswordEncoder passwordEncoder) {
		
		var provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(customerUserDetailsService);
		
		return provider;
	}
	
}
