package com.jdc.leaves.test.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.leaves.model.dto.input.ClassForm;
import com.jdc.leaves.model.dto.output.ClassListVO;
import com.jdc.leaves.model.service.ClassService;

@SpringJUnitConfig(locations = "/root-config.xml")
@Sql(scripts = {
		"/sql/truncate.sql",
		"/sql/classes.sql"
})
public class ClassServiceTest {

	@Autowired
	private ClassService service;

	@ParameterizedTest
	@CsvFileSource(resources = "/csv/classes/should_save_insert.csv")
	void should_save_insert(int id, int teacher, LocalDate start, int months, String description) {
		// Input Form
		var form = new ClassForm(id, teacher, start, months, description);

		// Test Method Execution
		var result = service.save(form);

		// Assertions
		assertThat(result, is(id));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/csv/classes/should_save_update.csv")
	void should_save_update(int id, int teacher, LocalDate start, int months, String description) {
		// Input Form
		var form = new ClassForm(id, teacher, start, months, description);

		// Test Method Execution
		var result = service.save(form);

		// Assertions
		assertThat(result, is(id));
	}

	@ParameterizedTest
	@CsvSource(value = {

	})
	void should_search(String teacher, LocalDate from, LocalDate to, int size) {

		// Test Method Execution
		var list = service.search(Optional.ofNullable(teacher), Optional.ofNullable(from), Optional.ofNullable(to));

		// Assertions
		assertThat(list, hasSize(size));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/csv/classes/should_find_form_by_id.csv")
	void should_find_form_by_id(int id, int teacher, LocalDate start, int months, String description) {
		// Test Method Execution
		var result = service.findById(id);

		// Assertions
		assertThat(result, is(new ClassForm(id, teacher, start, months, description)));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/csv/classes/should_find_details_by_id.csv")
	void should_find_details_by_id(int id, int teacherId, String teacherName, String teacherPhone, LocalDate startDate,
			int moths, String description, long studentCount, int registrations, int leaves) {
		// Test Method Execution
		var result = service.findDetailsById(id);

		// Prepare expected value
		assertThat(result, allOf(
				hasProperty("classInfo",
						is(new ClassListVO(id, teacherId, teacherName, teacherPhone, startDate, moths, description,
								studentCount))),
				hasProperty("registrations", hasSize(registrations)), 
				hasProperty("leaves", hasSize(leaves))));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/csv/classes/should_find_info_by_id.csv")
	void should_find_info_by_id(int id, int teacherId, String teacherName, String teacherPhone, LocalDate startDate,
			int moths, String description, long studentCount) {

		var result = service.findInfoById(id);

		assertThat(result, is(new ClassListVO(id, teacherId, teacherName, teacherPhone, startDate, moths, description,
				studentCount)));
	}
}
