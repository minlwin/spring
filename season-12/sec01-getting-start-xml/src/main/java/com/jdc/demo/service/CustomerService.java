package com.jdc.demo.service;

import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jdc.demo.service.dto.Customer;

@Service
public class CustomerService {
	
	private JdbcTemplate template;
	
	public CustomerService(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	public Optional<Customer> findOneByEmail(String email) {
		
		var customer = template.queryForObject("select * from CUSTOMER where email = ?", 
				new BeanPropertyRowMapper<>(Customer.class), email);
		
		return Optional.ofNullable(customer);
	}

}
