package com.jdc.spring.demo.security;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdc.spring.demo.model.AccountService;

@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	private AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return accountService.findByEmail(username)
				.map(dto -> User.withUsername(username)
						.password(dto.getPassword())
						.authorities(dto.getRole().name())
						.accountLocked(dto.isLocked() || !dto.isActivated())
						.accountExpired(isExpired(dto.getExpire_at()))
						.build()).orElseThrow(() -> new UsernameNotFoundException(username));
	}

	private boolean isExpired(Date expireAt) {
		
		if(null != expireAt) {
			return LocalDate.now().isBefore(expireAt.toLocalDate());
		}
		
		return false;
	}

}
