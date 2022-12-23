package com.jdc.orm.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = "com.jdc.orm.repo")
@EnableTransactionManagement
public class DataAccessConfig {

	@Bean
	DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.build();
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
			DataSource dataSource) {
		var bean = new LocalContainerEntityManagerFactoryBean();

		bean.setDataSource(dataSource);
		
		bean.setPackagesToScan("com.jdc.orm.entity");

		var jpaProperties = new HashMap<String, Object>();
		jpaProperties.put("jakarta.persistence.schema-generation.database.action", "drop-and-create");
		jpaProperties.put("hibernate.show_sql", true);
		jpaProperties.put("hibernate.format_sql", true);

		bean.setJpaPropertyMap(jpaProperties);
		
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return bean;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
