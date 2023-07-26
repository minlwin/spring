package com.jdc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(
		basePackages = "com.jdc.demo", 
		excludeFilters = {
				@Filter(classes = {Configuration.class}, type = FilterType.ANNOTATION)
		}
)
public class WebMvcConfiguration implements WebMvcConfigurer{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/home");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/member").setViewName("member");
	}

	@Bean
	SpringResourceTemplateResolver templateResolver() {
		var bean = new SpringResourceTemplateResolver();
		bean.setCacheable(false);
		bean.setPrefix("/views/");
		bean.setSuffix(".html");
		return bean;
	}
	
	@Bean
	SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
		var bean = new SpringTemplateEngine();
		bean.setTemplateResolver(templateResolver);
		return bean;
	}
	
	@Bean
	ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine templateEngine) {
		var bean = new ThymeleafViewResolver();
		bean.setTemplateEngine(templateEngine);
		return bean;
	}
}
