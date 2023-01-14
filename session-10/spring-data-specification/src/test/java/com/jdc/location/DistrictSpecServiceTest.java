package com.jdc.location;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.location.model.service.DistrictSpecService;

@SpringBootTest
public class DistrictSpecServiceTest {

	@Autowired
	private DistrictSpecService service;
	
	@Test
	void demo() {
		
		var list = service.search(null, 0, "Mo");
		
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}
}
