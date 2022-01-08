package com.jdc.async.controller.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.web.servlet.ModelAndView;

public class CallabeTask implements Callable<ModelAndView>{
	
	private List<String> messages;
	
	public CallabeTask() {
		messages = Collections.synchronizedList(new ArrayList<String>());
	}
	
	public void add(String message) {
		this.messages.add(message);
	}
	
	public List<String> getMessages() {
		return messages;
	}

	@Override
	public ModelAndView call() throws Exception {
		var mv = new ModelAndView("async-result");
		Thread.sleep(1500);
		mv.getModel().put("message", "Callable Processing is Done Successfully.");
		mv.getModel().put("interceptorsMessages", messages);
		return mv;
	}

}
