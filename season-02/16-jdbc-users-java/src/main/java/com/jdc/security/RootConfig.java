package com.jdc.security;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.security.web.authentication.logout.LogoutFilter;

import com.jdc.security.services.filter.CustomSecurityFilter;

@EnableWebSecurity
@ComponentScan("com.jdc.security.services")
public class RootConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomSecurityFilter customFilter;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser(User.builder().username("admin").authorities("Admin").password(passwordEncoder().encode("admin")));
		
		auth.jdbcAuthentication()
			.passwordEncoder(passwordEncoder())
			.dataSource(dataSource())
			.usersByUsernameQuery("select login, password, valid from user where login = ?")
			.authoritiesByUsernameQuery("select login, role from user where login = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.authorizeRequests().antMatchers("/admin/**").hasAuthority("Admin");
		http.authorizeRequests().antMatchers("/member/**").hasAnyAuthority("Member", "Admin");
		
		http.formLogin()
			.loginPage("/login").loginProcessingUrl("/login")
			.usernameParameter("loginId").passwordParameter("password");
		
		http.logout()
			.logoutUrl("/logout").logoutSuccessUrl("/");
		
		
		http.addFilterAfter(customFilter, LogoutFilter.class);
	}
	
	@Bean
	DataSource dataSource() {
		var ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/auth_db");
		ds.setUsername("root");
		ds.setPassword("admin");
		return ds;
	}
	
	@Bean
	SimpleJdbcInsert userInsert(DataSource dataSource)  {
		var insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("user");
		insert.setColumnNames(List.of("name", "login", "password"));
		return insert;
	}
	
	@Bean
	SimpleJdbcInsert accessInfoInsert(DataSource dataSource) {
		var insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("access_info");
		insert.setColumnNames(List.of("login_id", "type"));
		return insert;
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

}
