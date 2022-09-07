package com.jdc.leaves.test.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.leaves.model.dto.input.RegistrationForm;
import com.jdc.leaves.model.dto.output.StudentListVO;
import com.jdc.leaves.model.service.StudentService;

@SpringJUnitConfig(locations = "/root-config.xml")
public class StudentServiceTest {
	@Autowired
	private StudentService service;
	
	@ParameterizedTest
	@Sql(scripts = "/sql/truncate.sql")
	@CsvSource(value = {
			"Alex,alex@gmail.com,0922223333,BEHS",
			"Bo Bo,bobo@gmail.com,0955553333,College"
	})
	void should_create_successfully(String name, String email, String phone, String education) {
		var result = service.createStudent(new RegistrationForm(name, email, phone, education));
		assertThat(result, equalTo(1));
	}
	
	@ParameterizedTest
	@Sql(scripts = {
			"/sql/truncate.sql",
			"/sql/student.sql"
	})
	@CsvSource(value = {
			"1,alex@gmail.com",
			"2,bobo@gmail.com",
			"3,thein@gmail.com"
	})
	void should_found_by_email(int id, String email) {
		var result = service.findStudentByEmail(email);
		assertThat(result, equalTo(id));
	}
	
	@ParameterizedTest
	@Sql(scripts = {
			"/sql/truncate.sql",
			"/sql/student.sql"
	})
	@ValueSource(strings = {
			"alex1@gmail.com",
			"bobo1@gmail.com",
			"thein1@gmail.com"
	})
	void should_not_found_by_email(String email) {
		var result = service.findStudentByEmail(email);
		assertThat(result, nullValue());
	}
	
	@ParameterizedTest
	@Sql(scripts = {
			"/sql/truncate.sql",
			"/sql/student.sql"
	})
	@CsvSource(value = {
			"1,Alex,0911112222,alex@gmail.com,BEHS,1",
			"2,Bo Bo,0911112223,bobo@gmail.com,Master,1",
			"3,Thein Thein,0911112224,thein@gmail.com,BEHS,1"			
	})
	void should_found_by_id(int id, String name, String phone, String email, String education, long classCount) {
		
		// Assertions
		assertThat(
				service.findInfoById(id), 
				equalTo(new StudentListVO(id, name, phone, email, education, classCount)));
	}
	
	@ParameterizedTest
	@Sql(scripts = {
			"/sql/truncate.sql",
			"/sql/student.sql"
	})
	@ValueSource(ints = {4, 5, 6})
	void should_not_found_by_id(int id) {
		assertThrows(EmptyResultDataAccessException.class, () -> service.findInfoById(id));
	}
	
	@ParameterizedTest
	@Sql(scripts = {
			"/sql/truncate.sql",
			"/sql/student.sql"
	})
	@CsvSource(value = {
			"alex,,,1",
			"ALEX,,,1",
			"al,,,1",
			"ALEX1,,,0",
			"ALEX,0911112222,,1",
			"ALEX,0911112222,alex@gmail.com,1",
			"ALEX,09111122,alex@gmail.com,1",
			",09111122,,3",
	})
	void should_search_succefully(String name, String phone, String email, int size) {
		assertThat(service.search(
				Optional.ofNullable(name), 
				Optional.ofNullable(phone), 
				Optional.ofNullable(email)), hasSize(size));
	}
}
