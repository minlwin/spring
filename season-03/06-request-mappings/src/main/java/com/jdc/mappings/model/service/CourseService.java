package com.jdc.mappings.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.jdc.mappings.model.dto.Course;

@Service
public class CourseService {

	@Autowired
	private SimpleJdbcInsert courseInsert;
	
	private RowMapper<Course> rowMapper;
	
	public CourseService() {
		rowMapper = new BeanPropertyRowMapper<>(Course.class);
	}

	public int save(Course c) {
		
		if(c.getId() > 0) {
			courseInsert.getJdbcTemplate()
					.update("update course set name = ?, level = ?, duration = ?, fees = ? where id = ?", 
							c.getName(), c.getLevel().name(), 
							c.getDuration(), c.getFees(), c.getId());
			
			return c.getId();
		}
		
		var params = new HashMap<String, Object>();
		params.put("name", c.getName());
		params.put("level", c.getLevel().name());
		params.put("fees", c.getFees());
		params.put("duration", c.getDuration());
		
		return courseInsert.executeAndReturnKeyHolder(params).getKey().intValue();
	}


	public Course findByid(int id) {
		return courseInsert.getJdbcTemplate().query("select * from course where id = ?", rowMapper, id)
				.stream().findAny().orElse(null);
	}

	public List<Course> getAll() {
		return courseInsert.getJdbcTemplate().query("select * from course", rowMapper);
	}
}
