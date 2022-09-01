package com.jdc.leaves.test.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.leaves.model.dto.input.TeacherForm;
import com.jdc.leaves.model.service.TeacherService;

@SpringJUnitConfig(locations = "/root-config.xml")
public class TeacherServiceTest {
	
	@Autowired
	TeacherService service;

	@ParameterizedTest
	@CsvSource(value = "0,Maung Maung,097667888,maung@gmail.com,2022-09-01")
	@Sql(scripts = "/sql/truncate.sql")
	void save_insert_success(int id, String name, String phone, String email, LocalDate assignDate) {
		var form = new TeacherForm(id, name, phone, email, assignDate);
		var result = service.save(form);
		
		assertEquals(1, result);
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
	void find_by_id_test(int id, String name, String phone, String email, LocalDate assignDate, int classCount) {
		var result = service.findById(id);
		
		assertEquals(name, result.getName());
		assertEquals(phone, result.getPhone());
		assertEquals(email, result.getEmail());
		assertEquals(assignDate, result.getAssignDate());
		assertEquals(classCount, result.getClassCount());
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
	void search_test(String name, String phone, String email, int count) {
		
		var result = service.search(
				Optional.ofNullable(name), 
				Optional.ofNullable(phone), 
				Optional.ofNullable(email));
		
		assertEquals(count, result.size());
	}
}
