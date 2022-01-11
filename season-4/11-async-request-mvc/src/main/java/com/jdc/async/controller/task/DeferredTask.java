package com.jdc.async.controller.task;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

public class DeferredTask extends DeferredResult<ModelAndView>{

	private String error;
	
	public DeferredTask(long timeout) {
		super(timeout);
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public String getError() {
		return error;
	}

	
}
