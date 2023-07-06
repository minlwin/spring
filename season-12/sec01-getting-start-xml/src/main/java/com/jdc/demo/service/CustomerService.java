package com.jdc.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jdc.demo.service.dto.Customer;
import com.jdc.demo.service.dto.SignUpForm;
import com.jdc.demo.service.exceptions.BusinessException;

@Service
public class CustomerService {
	
	private JdbcTemplate template;
	private SimpleJdbcInsert insert;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public CustomerService(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("CUSTOMER");
		insert.setColumnNames(List.of("email", "name", "password", "activated", "validpass"));
	}

	public Optional<Customer> findOneByEmail(String email) {
		
		try {
			var customer = template.queryForObject("select * from CUSTOMER where email = ?", 
					new BeanPropertyRowMapper<>(Customer.class), email);
			
			return Optional.ofNullable(customer);
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	public void create(SignUpForm form) {
		
		// Check Email
		var result = findOneByEmail(form.getEmail());
		
		if(result.isPresent()) {
			throw new BusinessException("Your email has been already used.");
		}
		
		var params = new HashMap<String, Object>();
		params.put("name", form.getName());
		params.put("email", form.getEmail());
		params.put("password", passwordEncoder.encode(form.getPassword()));
		params.put("activated", true);
		params.put("validpass", Date.valueOf(LocalDate.now().plusMonths(1)));
		
		insert.execute(params);
	}

}
