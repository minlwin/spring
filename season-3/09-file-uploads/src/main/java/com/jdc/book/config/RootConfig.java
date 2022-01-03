package com.jdc.book.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan("com.jdc.book.root")
@EnableTransactionManagement
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		var ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/books_db");
		ds.setUsername("root");
		ds.setPassword("admin");
		return ds;
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedTemplate(DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}
	
	@Bean
	@Scope("prototype")
	public SimpleJdbcInsert jdbcInsert(DataSource ds) {
		return new SimpleJdbcInsert(ds);
	}
	
	@Bean
	@DependsOn("dataSource")
	public TransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	ReloadableResourceBundleMessageSource messageSource() {
		var source = new ReloadableResourceBundleMessageSource();
		source.setBasename("classpath:messages");
		source.setDefaultEncoding("UTF-8");
		return source;
	}
	
	@Bean
	public Validator validator() {
		var validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

}
