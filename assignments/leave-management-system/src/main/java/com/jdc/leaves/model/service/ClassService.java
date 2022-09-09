package com.jdc.leaves.model.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.leaves.model.dto.input.ClassForm;
import com.jdc.leaves.model.dto.output.ClassDetailsVO;
import com.jdc.leaves.model.dto.output.ClassListVO;

@Service
public class ClassService {
	
	private static final String SELECT_PROJECTION = """
		select c.id id, t.id teacherId, a.name teacherName, t.phone teacherPhone, 
		c.start_date startDate, c.months, c.description, count(r.classes_id) studentCount
		from classes c join teacher t on t.id = c.teacher_id 
		join account a on a.id = t.id
		left join registration r on c.id = r.classes_id
		""";
	private static final String SELECT_GROUPBY = " group by c.id, t.id, a.name, t.phone, c.start_date, c.months, c.description";
	
	private NamedParameterJdbcTemplate template;
	private SimpleJdbcInsert insert;
	
	@Autowired
	private RegistrationService regService;
	@Autowired
	private LeaveService leaService;
	
	public ClassService(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource);
		
		insert.setTableName("classes");
		insert.setGeneratedKeyName("id");
		insert.setColumnNames(List.of("teacher_id", "start_date", "months", "description"));
	}

	public List<ClassListVO> search(Optional<String> teacher, Optional<LocalDate> from, Optional<LocalDate> to) {
		
		var sb = new StringBuffer(SELECT_PROJECTION);
		sb.append(" where 1 = 1");
		
		var param = new HashMap<String, Object>();
		
		sb.append(teacher.filter(StringUtils::hasText).map(a -> {
			param.put("teacher", a.toLowerCase().concat("%"));
			return " and lower(a.name) like :teacher";
		}).orElse(""));
		
		sb.append(from.map(a -> {
			param.put("from", Date.valueOf(a));
			return " and c.start_date >= :from";
		}).orElse(""));

		sb.append(to.map(a -> {
			param.put("to", Date.valueOf(a));
			return " and c.start_date <= :to";
		}).orElse(""));

		sb.append(SELECT_GROUPBY);

		return template.query(sb.toString(), param, new BeanPropertyRowMapper<>(ClassListVO.class));
	}

	public ClassForm findById(int id) {
		return template.queryForObject("select id, teacher_id teacher, start_date start, months, description from classes where id = :id", Map.of("id", id), new BeanPropertyRowMapper<>(ClassForm.class));
	}

	public ClassListVO findInfoById(int classId) {
		var sql = "%s where c.id = :id %s".formatted(SELECT_PROJECTION, SELECT_GROUPBY);
		return template.queryForObject(sql, Map.of("id", classId), new BeanPropertyRowMapper<>(ClassListVO.class));
	}

	public ClassDetailsVO findDetailsById(int classId) {
		
		var result = new ClassDetailsVO();

		// Class Info
		var sql = "%s where c.id = :id %s".formatted(SELECT_PROJECTION, SELECT_GROUPBY);
		var classListVO = template.queryForObject(sql, Map.of("id", classId), new BeanPropertyRowMapper<>(ClassListVO.class));
		result.setClassInfo(classListVO);
		
		// Registrations for Class
		result.setRegistrations(regService.searchByClassId(classId));
		
		// Leaves for Class
		result.setLeaves(leaService.search(Optional.of(classId), Optional.empty(), Optional.empty(), Optional.empty()));
		
		return result;
	}


	@Transactional
	public int save(ClassForm form) {
		if(form.getId() == 0) {
			return insert(form);
		}
		return update(form);
	}


	private int update(ClassForm form) {
		template.update("""
				update classes set teacher_id = :teacher, months = :months, 
				start_date = :start, description = :desp where id = :id
				""", Map.of(
						"teacher", form.getTeacher(),
						"months", form.getMonths(),
						"start", Date.valueOf(form.getStart()),
						"desp", form.getDescription(),
						"id", form.getId()
						));
		return form.getId();
	}

	private int insert(ClassForm form) {
		var generatedId = insert.executeAndReturnKey(Map.of(
				"teacher_id", form.getTeacher(),
				"start_date", Date.valueOf(form.getStart()),
				"months", form.getMonths(),
				"description", form.getDescription()
		));
		return generatedId.intValue();
	}

}