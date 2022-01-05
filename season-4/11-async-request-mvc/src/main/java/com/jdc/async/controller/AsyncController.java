package com.jdc.async.controller;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("async")
public class AsyncController {

	@GetMapping
	public Callable<String> index() {
		return new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "async-result";
			}
		};
	}
}
