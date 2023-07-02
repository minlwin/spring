package com.jdc.demo.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.service.dto.Address;


@Service
public class AddressService {
	
	private JdbcTemplate template;
	private SimpleJdbcInsert insert;
	
	public AddressService(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("ADDRESS");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of(
				"email", "name", "building", "street", "township", "division"));
	}

	public List<Address> findOwnAddress() {
		
		var authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication.isAuthenticated()) {
			var sql = "select * from ADDRESS where email = ?";
			return template.query(sql, new BeanPropertyRowMapper<>(Address.class), authentication.getName());
		}
		return List.of();
	}

	@Transactional
	public void save(Address form) {

		if(form.getId() == 0) {
			insert.execute(new BeanPropertySqlParameterSource(form));
		} else {
			var sql = """
					update ADDRESS 
					set name = ?, building = ?, street = ?, township = ?, division = ? 
					where id = ?""";
			
			template.update(sql, form.getName(), 
					form.getBuilding(), form.getStreet(), 
					form.getTownship(), form.getDivision(), form.getId());
		}
	}

	public Address findById(Integer id) {
		var sql = "select * from ADDRESS where id = ?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<>(Address.class), id);
	}
}
