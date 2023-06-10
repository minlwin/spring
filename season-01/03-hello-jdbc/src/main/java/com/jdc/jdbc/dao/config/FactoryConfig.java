package com.jdc.jdbc.dao.config;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;

import com.jdc.jdbc.dto.Member;

@Configuration
public class FactoryConfig {

	@Bean
	@Qualifier("memberInsert")
	public PreparedStatementCreatorFactory memberInsertCreatorFactory(@Value("${member.insert}")String sql) {
		return new PreparedStatementCreatorFactory(sql, new int[] {
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR
		});
	}

	@Bean
	@Qualifier("memberFindByNameLike")
	public PreparedStatementCreatorFactory memberFindByNameLikeCreatorFactory(@Value("${member.select.by.name}")String sql) {
		return new PreparedStatementCreatorFactory(sql, new int[] {
				Types.VARCHAR
		});
	}
	
	@Bean
	@Qualifier("memberFindByPk")
	public PreparedStatementCreatorFactory memberFindByPkCreatorFactory(@Value("${member.select.by.pk}")String sql) {
		return new PreparedStatementCreatorFactory(sql, new int[] {
				Types.VARCHAR
		});
	}
	
	@Bean
	@Qualifier("memberRowMapper")
	public RowMapper<Member> memberRowMapper() {
		return new BeanPropertyRowMapper<>(Member.class);
	}
}
