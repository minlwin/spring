package com.jdc.book.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jdc.book.mvc.formatters.CategoryFormatter;

@Configuration
@EnableWebMvc
@ComponentScan("com.jdc.book.mvc")
public class MvcConfig implements WebMvcConfigurer{
	
	@Autowired
	private CategoryFormatter categoryFormatter;
	
	@Autowired
	private Validator validator;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/home");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/views/", ".jsp");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(categoryFormatter);
	}
	
	@Override
	public Validator getValidator() {
		return validator;
	}
}
