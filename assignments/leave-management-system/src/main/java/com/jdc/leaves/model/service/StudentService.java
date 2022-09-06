package com.jdc.leaves.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.leaves.model.dto.input.RegistrationForm;
import com.jdc.leaves.model.dto.output.StudentListVO;

@Service
public class StudentService {
	
	private static final String SELECT_PROJECTION = """
			select s.id, a.name, s.phone, a.email, s.education, count(r.class_id) classCount 
			from student s 
			join account a on s.id = a.id 
			left join registration r on s.id = r.student_id 
			""";
	
	private static final String SELECT_GROUPBY = """
			select s.id, a.name, s.phone, a.email, s.education
			""";
	
	private NamedParameterJdbcTemplate template;
	private SimpleJdbcInsert studentInsert;
	private SimpleJdbcInsert accountInsert;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public StudentService(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
		
		studentInsert = new SimpleJdbcInsert(dataSource);
		studentInsert.setTableName("student");
		
		accountInsert = new SimpleJdbcInsert(dataSource);
		accountInsert.setTableName("account");
		accountInsert.setGeneratedKeyName("id");
		accountInsert.setColumnNames(List.of(
				"name", "role", "email", "password"
		));
	}

	public List<StudentListVO> search(Optional<String> name, Optional<String> phone, Optional<String> email) {
		
		var sb = new StringBuffer(SELECT_PROJECTION);
		sb.append(" where 1 = 1");
		var params = new HashMap<String, Object>();
		
		
		sb.append(SELECT_GROUPBY).append(" order by a.name");
		return template.query(sb.toString(), params, new BeanPropertyRowMapper<>());
	}

	public StudentListVO findInfoById(int studentId) {	
		var sql = "%s wehre s.id = :id %s".formatted(SELECT_PROJECTION, SELECT_GROUPBY);
		return template.queryForObject(sql, Map.of("id", studentId), new BeanPropertyRowMapper<>());
	}

	public Integer findStudentByEmail(String email) {
		return template.queryForObject("""
				select s.id from student s join account a on s.id = a.id where a.email = :email
				""", Map.of("email", email), Integer.class);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Integer createStudent(RegistrationForm form) {
		// Insert into Account
		var generatedId = accountInsert.executeAndReturnKey(Map.of(
				"name", form.getStudentName(),
				"role", "Student",
				"email", form.getEmail(),
				"password", passwordEncoder.encode(form.getPhone())
		));
		
		// Insert into teacher
		studentInsert.execute(Map.of(
				"id", generatedId.intValue(),
				"phone", form.getPhone(),
				"education", form.getEducation()
		));
		
		return generatedId.intValue();
	}

}