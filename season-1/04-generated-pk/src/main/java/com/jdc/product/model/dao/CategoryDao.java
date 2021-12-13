package com.jdc.product.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jdc.product.model.dto.Category;

@Repository
public class CategoryDao {
	
	@Autowired
	private SimpleJdbcInsert insert;
	
	@Value("${dao.category.update}")
	private String update;
	@Value("${dao.category.findById}")
	private String findById;
	@Value("${dao.category.findByNameLike}")
	private String findByNameLike;
	@Value("${dao.category.findCountByNameLike}")
	private String findCountByNameLike;
	@Value("${dao.category.delete}")
	private String delete;
	
	private BeanPropertyRowMapper<Category> rowMapper;
	
	public CategoryDao() {
		rowMapper = new BeanPropertyRowMapper<>(Category.class);
	}
	
	
	public int create(Category c) {
		Map<String, Object> params = new HashMap<>();
		params.put("name", c.getName());		
		return insert.executeAndReturnKey(params).intValue();
	}


	public int update(Category c) {
		return insert.getJdbcTemplate().update(update, c.getName(), c.getId());
	}


	public Category findById(int id) {
		return insert.getJdbcTemplate().queryForObject(findById, rowMapper, id);
	}


	public List<Category> findByNameLike(String name) {
		return insert.getJdbcTemplate().query(findByNameLike, rowMapper, name.toLowerCase().concat("%"));
	}


	public int findCountByNameLike(String name) {
		return insert.getJdbcTemplate().queryForObject(findCountByNameLike, Integer.class, name.toLowerCase().concat("%"));
	}


	public int delete(int id) {
		return insert.getJdbcTemplate().update(delete, id);
	}
}
