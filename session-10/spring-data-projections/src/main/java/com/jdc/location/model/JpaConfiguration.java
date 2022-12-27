package com.jdc.location.model;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = "com.jdc.location.model")
@EnableJpaRepositories(basePackages = "com.jdc.location.model.repo")
public class JpaConfiguration {

	@Bean
	DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
	}
	
	@Bean
	FactoryBean<EntityManagerFactory> entityManagerFactory(DataSource dataSource) throws Exception {
		var factory = new LocalContainerEntityManagerFactoryBean();

		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setJpaProperties(jpaProperties());
		factory.setPackagesToScan("com.jdc.location.model.entity");
		
		factory.setDataSource(dataSource);

		return factory;
	}
	
	@Bean
	PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	private Properties jpaProperties() throws Exception {
		var prop = new Properties();
		prop.load(getClass().getResourceAsStream("/jpa.properties"));
		return prop;
	}
}
