package com.jdc.hello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class LegacyController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		var modelView = new ModelAndView("old-style");
		modelView.getModel().put("message", "Hello from Legacy Controller!");
		
		return modelView;
	}

}
