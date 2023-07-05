package com.jdc.spring.demo;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationWebLoader extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {	
			WebMvcConfiguration.class, 
			DatabaseConfiguration.class, 
			WebSecurityAdminConfiguration.class,
			WebSecurityMemberConfiguration.class,
			WebSecurityCustomerConfiguration.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
