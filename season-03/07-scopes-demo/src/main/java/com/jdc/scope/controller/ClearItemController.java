package com.jdc.scope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("cart")
public class ClearItemController {

	@GetMapping("clear-session")
	String clear(SessionStatus session) {
		session.setComplete();
		return "redirect:/";
	}
}
