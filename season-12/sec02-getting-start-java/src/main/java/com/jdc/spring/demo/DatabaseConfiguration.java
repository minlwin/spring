package com.jdc.spring.demo;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.cj.jdbc.Driver;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
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
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		var bean = new LocalContainerEntityManagerFactoryBean();
		
		bean.setDataSource(dataSource);
		bean.setPackagesToScan("com.jdc.spring.demo.service.entity");
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		
		bean.setJpaPropertyMap(Map.of(
				"hibernate.show_sql", "true",
				"hibernate.format_sql", "true"
				));
		
		return bean;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
