package com.jdc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jdc.demo.controller")
public class AppConfiguration implements WebMvcConfigurer{

	@Bean
	SpringResourceTemplateResolver templateResolver() {
		var bean = new SpringResourceTemplateResolver();
		bean.setPrefix("/views/");
		bean.setSuffix(".html");
		bean.setCacheable(false);
		return bean;
	}
	
	@Bean
	SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
		var engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver);
		return engine;
	}
	
	@Bean
	ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		var bean = new ThymeleafViewResolver();
		bean.setTemplateEngine(templateEngine);
		return bean;
	}
}
