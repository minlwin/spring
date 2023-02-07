package com.jdc.spring.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class InternationalizationConfig {

	@Bean
	MessageSource messageSource() {
		var bean = new ResourceBundleMessageSource();
		bean.addBasenames("inter/app-labels");
		return bean;
	}
	
	@Bean
	SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	
	@Bean
	LocaleChangeInterceptor localeChangeInterceptor() {
		var bean = new LocaleChangeInterceptor();
		bean.setParamName("lang");
		return bean;
	}
	
}
