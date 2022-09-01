package com.jdc.leaves.model.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.leaves.model.dto.input.TeacherForm;
import com.jdc.leaves.model.dto.output.TeacherListVO;

@Service
public class TeacherService {
	
	private NamedParameterJdbcTemplate template;
	private SimpleJdbcInsert accountInsert;
	private SimpleJdbcInsert teacherInsert;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public TeacherService(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
		
		accountInsert = new SimpleJdbcInsert(dataSource);
		accountInsert.setTableName("account");
		accountInsert.setGeneratedKeyName("id");
		
		teacherInsert = new SimpleJdbcInsert(dataSource);
		teacherInsert.setTableName("teacher");
	}
	
	@Transactional
	public int save(TeacherForm form) {
		
		if(form.getId() == 0) {
			return insert(form);
		} 
		
		return update(form);
	}


	public List<TeacherListVO> search(Optional<String> name, Optional<String> phone, Optional<String> email) {
		// TODO implement here
		return List.of();
	}

	public TeacherListVO findById(int id) {
		// TODO implement here
		return null;
	}

	private int insert(TeacherForm form) {
		
		// Insert into Account
		var generatedId = accountInsert.executeAndReturnKey(Map.of(
				"name", form.getName(),
				"role", "Teacher",
				"email", form.getEmail(),
				"password", passwordEncoder.encode(form.getPhone())
		));
		
		// Insert into teacher
		teacherInsert.execute(Map.of(
				"id", generatedId.intValue(),
				"phone", form.getPhone(),
				"assign_date", Date.valueOf(form.getAssignDate())
		));
		
		return generatedId.intValue();
	}

	private int update(TeacherForm form) {
		
		// Update Account Table
		template.update("update account set name = :name where id = :id", 
				Map.of(
					"name", form.getName(),
					"id", form.getId()
				));
		
		// Update Teacher Table
		template.update("update teacher set phone = :phone, assign_date = :assign where id = :id", 
				Map.of(
					"phone", form.getPhone(),
					"assign", Date.valueOf(form.getAssignDate()),
					"id", form.getId()
				));
		
		return form.getId();
	}

}