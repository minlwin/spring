package com.jdc.async.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import com.jdc.async.controller.task.CallabeTask;
import com.jdc.async.controller.task.DeferredTask;
import com.jdc.async.service.MyDelayService;

@Controller
@RequestMapping("async")
public class AsyncController {
	
	@Autowired
	private MyDelayService service;

	@GetMapping("callable")
	public Callable<ModelAndView> callableExecution() {
		return new CallabeTask();
	}
	
	@GetMapping("deferred")
	public DeferredResult<ModelAndView> deferredExecution() {
		
		var result = new DeferredTask(3000L);
		
		result.onCompletion(()-> {
			System.out.println("Request has been completed.");
		});
		
		result.onError(e -> {
			System.out.println("""
					========> Exception : From Handler Method
					""");
		});
		
		service.execute(result);
		
		return result;
	}
	
	@ExceptionHandler({
		RuntimeException.class,
		IllegalStateException.class
	})
	ModelAndView handle(Exception e) {
		var mv = new ModelAndView("error-result");
		mv.getModel().put("message", e.getMessage());
		return mv;
	}
	
}
