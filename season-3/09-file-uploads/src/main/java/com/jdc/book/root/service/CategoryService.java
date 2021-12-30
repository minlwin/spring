package com.jdc.book.root.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.jdc.book.root.dto.Category;

@Service
public class CategoryService {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private RowMapper<Category> rowMapper;
	
	public CategoryService() {
		rowMapper = new BeanPropertyRowMapper<>(Category.class);
	}

	public List<Category> getAll() {
		return template.query("select * from category order by name", rowMapper);
	}
	
	public Optional<Category> findById(int id) {
		return template.queryForStream("select * from category where id = :id", 
				Map.of("id", id), rowMapper).findFirst();
	}

}
