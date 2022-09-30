package com.jdc.leaves.model.security;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LeaveApplicationUserService implements UserDetailsService{

	private NamedParameterJdbcTemplate template;
	
	public LeaveApplicationUserService(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		var list = template.query("select * from account where email = :email", 
				Map.of("email", username), 
				new BeanPropertyRowMapper<>(AccountDto.class));
		
		if(!list.isEmpty()) {
			var account = list.get(0);
			
			return User.builder()
					.username(account.getEmail())
					.password(account.getPassword())
					.authorities(account.getRole())
					.accountExpired(account.isDeleted())
					.build();
		}
		
		throw new UsernameNotFoundException(username);
	}


}