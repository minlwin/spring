package com.jdc.location;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.jdc.location.model.entity.District;
import com.jdc.location.model.service.DistrictSpecService;

@SpringBootTest
class SpringDataSortingApplicationTests {
	
	@Autowired
	private DistrictSpecService repo;

	@Test
	void contextLoads() {
		
		var typeSort = Sort.sort(District.class);

		var list = repo.searchByRegion("East", typeSort.by(District::getName).descending());
		
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}
	
}
