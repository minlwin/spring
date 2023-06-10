package com.jdc.security.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.security.services.AccessInfoService;

@Controller("memberHomeController")
@RequestMapping("member")
public class HomeController {
	
	@Autowired
	private AccessInfoService service;

	@GetMapping("home")
	public void home(ModelMap model) {
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User user) {
			model.put("accessList", service.getInfo(user.getUsername()));
		}
	}
}
