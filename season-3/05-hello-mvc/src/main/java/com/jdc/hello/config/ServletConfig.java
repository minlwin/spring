package com.jdc.hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jdc.hello.controller.interceptors.HelloInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.jdc.hello.controller")
public class ServletConfig implements WebMvcConfigurer{
	
	@Autowired
	private HelloInterceptor helloInterceptor;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/hello");
	}
	
	@Bean
	public ViewResolver jspViewResolver() {
		return new InternalResourceViewResolver("/views/", ".jsp");
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(helloInterceptor);
	}
}
