package com.jdc.demo.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jdc.demo.service.dto.Address;


@Service
public class AddressService {
	
	private JdbcTemplate template;
	
	public AddressService(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	public List<Address> findOwnAddress() {
		
		var authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication.isAuthenticated()) {
			var sql = "select * from ADDRESS where email = ?";
			return template.query(sql, new BeanPropertyRowMapper<>(Address.class), authentication.getName());
		}
		return List.of();
	}
}
