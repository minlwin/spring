package com.jdc.tx.demo.model.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class AccountHistoryDao {

	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public AccountHistoryDao(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("account_history");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of());
	}
}
