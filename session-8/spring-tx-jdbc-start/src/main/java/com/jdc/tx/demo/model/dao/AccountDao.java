package com.jdc.tx.demo.model.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jdc.tx.demo.model.dto.Account;

@Repository
public class AccountDao {

	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("account");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of(
				"name", "phone", "email", "amount"
		));
		
	}
	
	Account findById(int id) {
		return jdbcTemplate.queryForObject("select * from account where id = :id", 
				Map.of("id", id),new DataClassRowMapper<>(Account.class));
	}
	
	Account insert(Account account) {
		var id = insert.executeAndReturnKey(new BeanPropertySqlParameterSource(account)).intValue();
		return findById(id);
	}
	
	Account updateAmount(int account, int amount) {
		jdbcTemplate.update("update account amount = :amount where id = :id", 
				Map.of("id", account, "amount", amount));
		return findById(account);
	}
}
