package com.jdc.spring.demo;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.jdbc.Driver;

@Configuration
public class DatabaseConfiguration {

	@Bean
	DataSource dataSource() {
		var bean = new BasicDataSource();
		bean.setUrl("jdbc:mysql://localhost:3306/security_db");
		bean.setUsername("securityusr");
		bean.setPassword("securitypwd");
		bean.setDriverClassName(Driver.class.getName());
		return bean;
	}
}
