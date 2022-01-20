package com.jdc.security.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.security.services.AccessInfoService;

@Controller("adminHomeController")
@RequestMapping("admin")
public class HomeController {
	
	@Autowired
	private AccessInfoService service;

	@GetMapping("home")
	public void home(ModelMap model) {
		model.put("list", service.getAllInfo());
	}
}
