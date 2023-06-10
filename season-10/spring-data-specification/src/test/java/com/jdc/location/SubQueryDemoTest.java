package com.jdc.location;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.location.model.service.SubQueryDemoService;

@SpringBootTest
public class SubQueryDemoTest {

	@Autowired
	private SubQueryDemoService service;
	
	@Test
	void demo() {
		var list = service.search("mo");
		
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}
}
