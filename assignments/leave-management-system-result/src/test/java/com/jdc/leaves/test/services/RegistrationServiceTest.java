package com.jdc.leaves.test.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.leaves.model.dto.input.RegistrationForm;
import com.jdc.leaves.model.dto.output.ClassListVO;
import com.jdc.leaves.model.dto.output.StudentListVO;
import com.jdc.leaves.model.service.RegistrationService;

@SpringJUnitConfig(locations = "/root-config.xml")
@Sql(scripts = { 
		"/sql/truncate.sql", 
		"/sql/registrations.sql"
})
public class RegistrationServiceTest {

	@Autowired
	private RegistrationService service;

	@ParameterizedTest
	@CsvFileSource(resources = "/csv/registration/should_create_new_student.csv", delimiter = '\t')
	void should_create_new_student(int classId, int studentId, LocalDate registDate, String studentName, String email,
			String phone, String education) {

		var form = new RegistrationForm(classId, 0, registDate, studentName, email, phone, education);

		service.save(form);

		assertThat(form, allOf(hasProperty("studentId", is(studentId)), hasProperty("registDate", is(LocalDate.now()))));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/csv/registration/should_create_old_student.csv", delimiter = '\t')
	void should_create_old_student(int classId, int studentId, LocalDate registDate, String studentName, String email,
			String phone, String education) {
		var form = new RegistrationForm(classId, 0, registDate, studentName, email, phone, education);

		service.save(form);

		assertThat(form,
				allOf(hasProperty("studentId", is(studentId)), hasProperty("registDate", is(LocalDate.now()))));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/csv/registration/should_update.csv", delimiter = '\t')
	void should_update(int classId, int studentId, LocalDate registDate, String studentName, String email, String phone,
			String education) {
		var form = new RegistrationForm(classId, studentId, registDate, studentName, email, phone, education);

		service.save(form);

		assertThat(form, allOf(hasProperty("studentId", is(studentId)), hasProperty("registDate", is(registDate))));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/csv/registration/should_find_form_by_id.csv", delimiter = '\t')
	void should_find_form_by_id(int classId, int studentId, LocalDate registDate, String studentName, String email,
			String phone, String education) {

		var result = service.getFormById(classId, studentId);

		assertThat(result,
				is(new RegistrationForm(classId, studentId, registDate, studentName, email, phone, education)));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/csv/registration/should_find_details_by_id.csv", delimiter = '\t')
	void should_find_details_by_id(int classId, int studentId, LocalDate registDate, int teacherId, String teacherName,
			String teacherPhone, LocalDate startDate, int moths, String description, long studentCount, String name,
			String phone, String email, String education, long classCount) {
		
		var result = service.findDetailsById(classId, studentId);
		
		var classInfo = new ClassListVO(classId, teacherId, teacherName, teacherPhone, startDate, moths, description, studentCount);
		var student = new StudentListVO(studentId, name, phone, email, education, classCount);
		
		assertThat(result, allOf(
				hasProperty("registDate", is(registDate)),
				hasProperty("classInfo", is(classInfo)),
				hasProperty("student", is(student))
		));

	}

	@ParameterizedTest
	@CsvSource(value = {
			"1,3",
			"2,2",
			"3,0",
	})
	void should_search_by_class_id(int classId, int size) {
		var list = service.searchByClassId(classId);
		assertThat(list, hasSize(size));
	}

}
