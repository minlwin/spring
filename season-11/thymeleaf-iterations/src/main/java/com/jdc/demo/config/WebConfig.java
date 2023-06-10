package com.jdc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jdc.demo.controller")
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/states");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/static/");
	}
	
	@Bean
	SpringResourceTemplateResolver templateResolver() {
		var bean = new SpringResourceTemplateResolver();
		bean.setPrefix("/templates/");
		bean.setSuffix(".html");
		bean.setCacheable(false);
		return bean;
	}
	
	@Bean
	SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
		var bean = new SpringTemplateEngine();
		bean.setTemplateResolver(templateResolver);
		return bean;
	}
	
	@Bean
	ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		var bean = new ThymeleafViewResolver();
		bean.setTemplateEngine(templateEngine);
		return bean;
	}
}
