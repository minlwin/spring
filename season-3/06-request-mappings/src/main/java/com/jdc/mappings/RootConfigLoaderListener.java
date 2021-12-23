package com.jdc.mappings;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

public class RootConfigLoaderListener extends ContextLoaderListener {

	public RootConfigLoaderListener(WebApplicationContext context) {
		super(context);
	}

	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, null);
		return super.initWebApplicationContext(servletContext);
	}
}
