package com.jdc.security;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@ComponentScan("com.jdc.security.services")
public class RootConfig extends WebSecurityConfigurerAdapter{

	@Bean
	DataSource dataSource() {
		var bean = new BasicDataSource();
		bean.setUrl("jdbc:mysql://localhost:3306/auth_db");
		bean.setUsername("root");
		bean.setPassword("admin");
		return bean;
	}
	
	@Bean
	SimpleJdbcInsert userInsert(DataSource dataSource) {
		var bean = new SimpleJdbcInsert(dataSource);
		bean.setTableName("user");
		bean.setColumnNames(List.of("login", "password", "name"));
		return bean;
	}
	
	@Bean
	PasswordEncoder bcryptEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser(User.builder().username("admin").authorities("Admin").password(bcryptEncoder().encode("admin")));
		
		auth.jdbcAuthentication()
			.passwordEncoder(bcryptEncoder())
			.dataSource(dataSource())
			.usersByUsernameQuery("select login, password, valid from user where login = ?")
			.authoritiesByUsernameQuery("select login, role from user where login = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
			.antMatchers("/admin/**").hasAuthority("Admin")
			.antMatchers("/member/**").hasAnyAuthority("Member", "Admin");
		
		http.formLogin()
			.loginPage("/login").loginProcessingUrl("/login")
			.usernameParameter("loginId").passwordParameter("password");
		
		http.logout()
			.logoutUrl("/logout").logoutSuccessUrl("/");
	}
	
	@Bean("authManager")
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

}
