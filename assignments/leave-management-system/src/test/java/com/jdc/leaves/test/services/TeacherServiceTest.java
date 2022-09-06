package com.jdc.leaves.test.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.leaves.model.dto.input.TeacherForm;
import com.jdc.leaves.model.dto.output.TeacherListVO;
import com.jdc.leaves.model.service.TeacherService;


@SpringJUnitConfig(locations = "/root-config.xml")
public class TeacherServiceTest {
	
	@Autowired
	TeacherService service;

	@ParameterizedTest
	@CsvSource(value = "0,Maung Maung,097667888,maung@gmail.com,2022-09-01")
	@Sql(scripts = "/sql/truncate.sql")
	void should_insert_succefully(int id, String name, String phone, String email, LocalDate assignDate) {
		// Prepare Input Form
		var form = new TeacherForm(id, name, phone, email, assignDate);
		
		// Execute Test Method
		var result = service.save(form);
		
		// Assertions
		assertThat(result, equalTo(1));
	}
	
	@ParameterizedTest
	@Sql(scripts = {
			"/sql/truncate.sql",
			"/sql/teacher.sql"
	})
	@CsvSource(value = {
			"1,Maung Maung,09782929282,maung@gmail.com,2022-08-01,2",
			"2,Aung Aung,0972626827,aung@gmail.com,2022-09-01,1",
			"3,Thidar,08928282711,thidar@gmail.com,2022-10-01,0"
			
	})
	void should_found_by_id(int id, String name, String phone, String email, LocalDate assignDate, int classCount) {
		
		// Expected Value
		var expected = new TeacherListVO(id, name, phone, email, assignDate, classCount);
		
		// Test Method Execution
		var result = service.findById(id);
		
		// Assertions
		assertThat(result, equalTo(expected));
	}
	
	@ParameterizedTest
	@Sql(scripts = {
			"/sql/truncate.sql",
			"/sql/teacher.sql"
	})
	@CsvSource(value = {
			",,,3",
			"thi,,,1",
			"myo,,,0",
			"thi,08928,,1",
			"thi,09928,,0",
			",08928,,1",
			",,aung,1",
			",,myo,0",
			"aung,0972626827,aung,1",
	})
	void should_search_with_results(String name, String phone, String email, int count) {
		
		var result = service.search(
				Optional.ofNullable(name), 
				Optional.ofNullable(phone), 
				Optional.ofNullable(email));
		
		assertThat(result, hasSize(count));
	}
	
	void should_update_successfully() {
		
	}
	
	void should_search_available_teachers() {
		
	}
}
