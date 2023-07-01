package com.jdc.spring.demo.service.security;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdc.spring.demo.service.CustomerService;
import com.jdc.spring.demo.service.entity.Customer;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomerService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return service.findByEmail(username)
				.map(customer -> User.withUsername(username)
						.authorities("Customer")
						.password(customer.getPassword())
						.accountLocked(customer.isLocked())
						.disabled(!customer.isActivated())
						.accountExpired(isExpired(customer))
						.credentialsExpired(isCredentialExpired(customer))
						.build())
				.orElseThrow(() -> new UsernameNotFoundException(username));
	}

	private boolean isCredentialExpired(Customer customer) {
		
		if(null != customer.getValidpass()) {
			var validDate = customer.getValidpass().toLocalDate();
			if(validDate.isBefore(LocalDate.now())) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isExpired(Customer customer) {
		
		if(null != customer.getRetired()) {
			var retired = customer.getRetired().toLocalDate();
			
			if(retired.isBefore(LocalDate.now())) {
				return true;
			}
		}
		
		return false;
	}
}
