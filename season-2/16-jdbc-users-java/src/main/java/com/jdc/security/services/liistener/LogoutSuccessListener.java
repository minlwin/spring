package com.jdc.security.services.liistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.jdc.security.services.AccessInfoService;
import com.jdc.security.services.model.AccessInfo.Type;

@Component
public class LogoutSuccessListener implements ApplicationListener<LogoutSuccessEvent>{
	
	@Autowired
	private AccessInfoService service;

	@Override
	public void onApplicationEvent(LogoutSuccessEvent event) {

		if(event.getAuthentication().getPrincipal() instanceof User user) {
			service.create(user.getUsername(), Type.Logout);
		}
	}

}
