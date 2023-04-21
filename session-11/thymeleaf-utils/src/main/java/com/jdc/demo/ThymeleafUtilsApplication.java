package com.jdc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@SpringBootApplication
public class ThymeleafUtilsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafUtilsApplication.class, args);
	}

	@Autowired
	public void setThymeleafViewResolver(ThymeleafViewResolver viewResolver) {
		viewResolver.addStaticVariable("hello", "Hello Thymeleaf Variable");
	}

}
