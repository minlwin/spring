package com.jdc.tx.demo.model.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jdc.tx.demo.model.dto.AccountHistory;

@Repository
public class AccountHistoryDao {
	
	private static final String SELECT_PROJECTION = """
			select h.id, h.transfer_id, t.issue_at, a.account_id, a.name account_name,
			h.type, h.before_amount, h.amount from account_history 
			join account a on h.account_id = a.id join transfer_log t on h.transfer_id = t.id""";

	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public AccountHistoryDao(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("account_history");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of("transfer_id", "account_id", 
				"type", "before_amount", "amount"));
	}
	
	public AccountHistory findById(int id) {
		return jdbcTemplate.queryForObject("%s where id = :id".formatted(SELECT_PROJECTION), 
				Map.of("h.id", id), 
				new DataClassRowMapper<>(AccountHistory.class));
	}
	
	public List<AccountHistory> findByTransfer(int id) {
		return jdbcTemplate.query("%s where id = :id".formatted(SELECT_PROJECTION), 
				Map.of("t.id", id), 
				new DataClassRowMapper<>(AccountHistory.class));
	}
	
	public AccountHistory create(AccountHistory history) {
		var id = insert.executeAndReturnKey(new BeanPropertySqlParameterSource(history));
		return findById(id.intValue());
	}
}
