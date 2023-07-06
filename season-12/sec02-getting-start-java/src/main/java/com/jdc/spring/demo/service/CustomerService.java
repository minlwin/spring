package com.jdc.spring.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.demo.service.dto.SignUpForm;
import com.jdc.spring.demo.service.entity.Customer;
import com.jdc.spring.demo.service.exceptions.BusinessException;
import com.jdc.spring.demo.service.repo.CustomerRepo;


@Service
@Transactional(readOnly = true)
public class CustomerService {

	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Optional<Customer> findByEmail(String email) {
		return repo.findById(email);
	}

	@Transactional
	public void create(SignUpForm form) {
		if(repo.findById(form.getEmail()).isPresent()) {
			throw new BusinessException("Your email has been already used.");
		}
		
		var entity = new Customer();
		entity.setName(form.getName());
		entity.setEmail(form.getEmail());
		entity.setPassword(passwordEncoder.encode(form.getPassword()));
		entity.setActivated(true);
		entity.setValidpass(Date.valueOf(LocalDate.now().plusMonths(1)));
		
		repo.save(entity);
	}
}
