package com.jdc.security.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jdc.security.services.model.SignUpDto;

@Service
public class SignUpService {
	
	@Autowired
	@Qualifier("authManager")
	private AuthenticationManager auth;
	
	@Autowired
	private SimpleJdbcInsert insert;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	public Authentication signUp(SignUpDto dto) {
		// insert into db
		var params = new HashMap<String, Object>();
		params.put("name", dto.getName());
		params.put("login", dto.getLoginId());
		params.put("password", bcryptEncoder.encode(dto.getPassword()));
		
		var result = insert.execute(params);
		
		// programmatic login
		if(result == 1) {
			var authToken = new UsernamePasswordAuthenticationToken(dto.getLoginId(), dto.getPassword());
			return auth.authenticate(authToken);
		}
		
		return null;
	}
}
