package com.jdc.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
public class ThymeleafConfig {

	@Bean
	SpringResourceTemplateResolver templateResolver() {
		var bean = new SpringResourceTemplateResolver();
		bean.setPrefix("classpath:/templates/");
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
		bean.setContentType("text/html");
		return bean;
	}
}
