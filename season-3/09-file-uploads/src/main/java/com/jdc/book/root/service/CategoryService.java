package com.jdc.book.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.jdc.book.root.dto.Category;

@Service
public class CategoryService {
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	public List<Category> getAll() {
		return template.query("select * from category order by name", 
				new BeanPropertyRowMapper<>(Category.class));
	}

}
