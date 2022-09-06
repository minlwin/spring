package com.jdc.leaves.model.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdc.leaves.model.dto.output.ClassListVO;

public class ClassListVoRowMapper implements RowMapper<ClassListVO>{

	@Override
	public ClassListVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		var vo = new ClassListVO();
		vo.setDescription(rs.getString("description"));
		vo.setId(rs.getInt("id"));
		vo.setMoths(rs.getInt("months"));
		vo.setStartDate(rs.getDate("startDate").toLocalDate());
		vo.setStudentCount(rs.getLong("studentCount"));
		vo.setTeacherId(rs.getInt("teacherId"));
		vo.setTeacherName(rs.getString("teacherName"));
		vo.setTeacherPhone(rs.getString("teacherPhone"));
		return vo;
	}

}
