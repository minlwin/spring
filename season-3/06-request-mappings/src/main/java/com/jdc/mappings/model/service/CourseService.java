package com.jdc.mappings.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.jdc.mappings.model.dto.Course;
import com.jdc.mappings.model.dto.Level;

@Service
public class CourseService {

	@Autowired
	private SimpleJdbcInsert courseInsert;
	
	private RowMapper<Course> rowMapper;
	
	public CourseService() {
		rowMapper = (rs, index) -> {
			var c = new Course();
			c.setId(rs.getInt("id"));
			c.setDuration(rs.getInt("duration"));
			c.setFees(rs.getInt("fees"));
			c.setLevel(Level.valueOf(rs.getString("level")));
			c.setName(rs.getString("name"));
			return c;
		};
	}

	public int create(Course c) {
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
