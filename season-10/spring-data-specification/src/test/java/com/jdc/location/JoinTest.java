package com.jdc.location;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.location.model.service.StateSpecService;

@SpringBootTest
public class JoinTest {

	@Autowired
	private StateSpecService service;
	
	@Test
	void test() {
		var list = service.findByDistrictNameLike("Mo");
		
		for(var dto : list) {
			System.out.println(dto);
		}
	}
}
