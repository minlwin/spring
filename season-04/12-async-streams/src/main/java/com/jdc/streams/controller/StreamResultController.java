package com.jdc.streams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.jdc.streams.service.DataProvider;
import com.jdc.streams.service.LostConnectionException;

@Controller
@RequestMapping("stream")
public class StreamResultController {
	
	@Autowired
	private DataProvider provider;

	@GetMapping
	public ResponseBodyEmitter index() {
		var emittor = new ResponseBodyEmitter(6000L);
		
		provider.stream(emittor);
		
		return emittor;
	}
	
	@ExceptionHandler
	public void handle(LostConnectionException e) {
		// Handler in Streaming Result is useless.
		System.out.println(">>>>> Handle from Handler");
	}
}
