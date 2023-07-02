package com.jdc.spring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.spring.demo.service.dto.AddressDto;
import com.jdc.spring.demo.service.repo.AddressRepo;
import com.jdc.spring.demo.service.repo.CustomerRepo;

@Service
@Transactional(readOnly = true)
public class AddressService {

	@Autowired
	private AddressRepo repo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public List<AddressDto> findOwnAddress() {
		
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		if(StringUtils.hasLength(username)) {
			return repo.streamByCustomerEmail(username)
					.map(AddressDto::new).toList();
		}
		
		return List.of();
	}
	
	public AddressDto findById(int id) {
		return repo.findById(id).map(AddressDto::new).orElseThrow();
	}
	
	@Transactional
	public void save(AddressDto form) {
		
		if(form.getId() == 0) {
			var username = SecurityContextHolder.getContext().getAuthentication().getName();
			var entity = form.entity();
			
			entity.setCustomer(customerRepo.findById(username).orElseThrow());
			
			repo.save(entity);
			
		} else {
			repo.findById(form.getId()).ifPresent(entity -> {
				entity.setName(form.getName());
				entity.setBuilding(form.getBuilding());
				entity.setStreet(form.getStreet());
				entity.setTownship(form.getTownship());
				entity.setDivision(form.getDivision());
			});
		}
		
	}
}
