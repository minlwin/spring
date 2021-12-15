package com.jdc.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public void index(Model model) {
		model.addAttribute("message", "Hello from Spring Hot Reload!");
	}
}
