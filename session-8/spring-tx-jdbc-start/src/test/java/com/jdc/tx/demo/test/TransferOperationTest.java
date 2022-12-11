package com.jdc.tx.demo.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.tx.demo.model.TransferService;
import com.jdc.tx.demo.model.dto.TransferForm;

@Sql("/initialize.sql")
@SpringJUnitConfig(locations = "classpath:/application.xml")
public class TransferOperationTest {

	@Autowired
	private TransferService service;
	
	@ParameterizedTest
	@CsvSource({
		"1,2,50000,2022-12-10 10:00"
	})
	void test(int from, int to, int amount, String time) {
		service.transfer(new TransferForm(from, to, amount, LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
	}
}
