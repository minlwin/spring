package com.jdc.spring.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.demo.model.AccountService;
import com.jdc.spring.demo.model.dto.AccountDto;
import com.jdc.spring.demo.model.dto.AccountDto.Role;

@Service
public class AdminUserInitializer {

	@Autowired
	private AccountService accountService;
	
	@Transactional
	@EventListener(ContextRefreshedEvent.class)
	public void inititalizeAdminUser() {
		
		if(accountService.getCount() == 0L) {
			var dto = new AccountDto();
			dto.setActivated(true);
			dto.setLocked(false);
			dto.setName("Admin User");
			dto.setRole(Role.Admin);
			dto.setEmail("admin@gmail.com");
			dto.setPassword("admin");
			
			accountService.create(dto);
		}
	}
}
