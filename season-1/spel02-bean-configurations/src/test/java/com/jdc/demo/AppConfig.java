package com.jdc.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	ImageFileProvider provider(@Value("#{systemProperties['user.home']}") String userHome) {
		var bean = new ImageFileProvider();
		bean.setBaseDirectory(userHome);
		return bean;
	}
}
