package com.jdc.leaves.model.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdc.leaves.model.dto.input.ClassForm;

public class ClassFormRowMapper implements RowMapper<ClassForm> {

	@Override
	public ClassForm mapRow(ResultSet rs, int rowNum) throws SQLException {
		var form = new ClassForm();
		form.setId(rs.getInt("id"));
		form.setTeacher(rs.getInt("teacher_id"));
		form.setStart(rs.getDate("start_date").toLocalDate());
		form.setMonths(rs.getInt("months"));
		form.setDescription(rs.getString("description"));
		return form;
	}

}
