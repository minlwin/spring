package com.jdc.streams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.jdc.streams.service.DataProvider;

@Controller
@RequestMapping("stream")
public class StreamResultController {
	
	@Autowired
	private DataProvider provider;

	@GetMapping
	public ResponseBodyEmitter index() {
		var emittor = new ResponseBodyEmitter();
		
		provider.stream(emittor);
		
		return emittor;
	}
}
