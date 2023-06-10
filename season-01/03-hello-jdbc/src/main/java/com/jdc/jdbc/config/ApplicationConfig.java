package com.jdc.jdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource("/database.properties")
@ComponentScan(basePackages = "com.jdc.jdbc.dao")
public class ApplicationConfig {
	
	@Value("${db.url}")
	private String url;
	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;

	@Bean
	public DataSource dataSource() {
		
		var config = new BoneCPConfig();
		config.setJdbcUrl(url);
		config.setUsername(user);
		config.setPassword(password);
		
		return new BoneCPDataSource(config);
	}
	
	@Bean
	public JdbcTemplate template(DataSource dataSource) {
		return new JdbcTemplate(dataSource, true);
	}
}
