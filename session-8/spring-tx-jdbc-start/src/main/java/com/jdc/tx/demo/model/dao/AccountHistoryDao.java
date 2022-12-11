package com.jdc.tx.demo.model.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jdc.tx.demo.model.dto.Account;
import com.jdc.tx.demo.model.dto.AccountHistory;
import com.jdc.tx.demo.model.dto.AccountHistory.Type;

@Repository
public class AccountHistoryDao {
	
	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate template;
	
	public AccountHistoryDao(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("account_history");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of("transfer_id", "account_id", "type", "before_amount", "amount"));
		template = new NamedParameterJdbcTemplate(dataSource);
	}

	public AccountHistory debit(int transferId, Account account, int amount) {
		var id = insert.executeAndReturnKey(Map.of(
				"transfer_id", transferId,
				"account_id", account.id(),
				"type", Type.Debit.name(),
				"before_amount", account.amount(),
				"amount", amount
				));
		return findById(id.intValue());
	}

	public AccountHistory credit(int transferId, Account account, int amount) {
		var id = insert.executeAndReturnKey(Map.of(
				"transfer_id", transferId,
				"account_id", account.id(),
				"type", Type.Credit.name(),
				"before_amount", account.amount(),
				"amount", amount
				));
		return findById(id.intValue());
	}
	
	private AccountHistory findById(int id) {
		return template.queryForObject("""
				select h.id, h.transfer_id, h.account_id, h.type, h.before_amount, h.amount, a.name account_name 
				from account_history h join account a on h.account_id = a.id where h.id = :id
				""", 
				Map.of("id", id), new DataClassRowMapper<>(AccountHistory.class));
	}
	
}
