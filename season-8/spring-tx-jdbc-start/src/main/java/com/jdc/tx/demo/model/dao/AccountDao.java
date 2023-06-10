package com.jdc.tx.demo.model.dao;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdc.tx.demo.model.dto.Account;

@Repository
public class AccountDao {
	
	private NamedParameterJdbcTemplate template;
	
	public AccountDao(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
	}

	public Account findById(int id) {
		return template.queryForObject("select * from account where id = :id", 
				Map.of("id", id), 
				new DataClassRowMapper<>(Account.class));
	}

	public void save(Account account) {
		template.update(
				"update account set amount = :amount where id = :id", 
				Map.of("amount", account.amount(), "id", account.id()));
	}


}
