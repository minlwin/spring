package com.jdc.async.controller;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
@RequestMapping("async")
public class AsyncController {

	@GetMapping("callable")
	public Callable<String> callableExecution(ModelMap model) {
		return new Callable<String>() {

			@Override
			public String call() throws Exception {
				model.put("message", "Hello From Callable Result");
				return "async-result";
			}
		};
	}
	
	@GetMapping("deferred")
	public DeferredResult<String> deferredExecution(ModelMap model) {
		var result = new DeferredResult<String>(1000L,"async-result");
		model.put("message", "Hello From Deferred Result");
		return result;
	}
}
