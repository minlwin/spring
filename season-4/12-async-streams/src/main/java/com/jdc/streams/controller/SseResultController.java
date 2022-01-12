package com.jdc.streams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.jdc.streams.service.DataProvider;

@Controller
@RequestMapping("sse")
public class SseResultController {
	
	@Autowired
	private DataProvider provider;

	@GetMapping
	public SseEmitter stream() {
		var emitter = new SseEmitter();
		provider.stream(emitter);
		return emitter;
	}
}
