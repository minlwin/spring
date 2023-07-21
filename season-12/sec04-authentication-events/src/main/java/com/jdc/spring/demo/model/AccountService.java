package com.jdc.spring.demo.model;

import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.demo.model.dto.AccountDto;

@Service
public class AccountService {
	
	private NamedParameterJdbcTemplate template;
	private SimpleJdbcInsert insert;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public AccountService(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("account");
	}

	public Optional<AccountDto> findByEmail(String email) {
		var sql = "select * from account where email = :email";
		return template.queryForStream(sql, Map.of("email", email), new BeanPropertyRowMapper<AccountDto>(AccountDto.class))
				.findAny();
	}

	public long getCount() {
		var sql = "select count(*) from account";
		return template.queryForObject(sql, Map.of(), Long.class);
	}

	@Transactional
	public void create(AccountDto dto) {
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		insert.execute(new BeanPropertySqlParameterSource(dto));
	}
}
