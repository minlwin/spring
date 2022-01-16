package com.jdc.security.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("memberHomeController")
@RequestMapping("member")
public class HomeController {

	@GetMapping("home")
	public void home() {
		
	}
}
