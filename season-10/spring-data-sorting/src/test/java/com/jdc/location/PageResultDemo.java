package com.jdc.location;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.jdc.location.model.repo.DistrictRepo;

@SpringBootTest
public class PageResultDemo {

	@Autowired
	private DistrictRepo repo;
	
	@Test
	void demo() {
		
		var pageParam = PageRequest.of(1, 5, Sort.by("name"));
		
		var result = repo.findByStateRegion("East", pageParam);
		
		System.out.printf("Elements : %d%n", result.getTotalElements());
		System.out.printf("Pages    : %d%n", result.getTotalPages());
		System.out.printf("Current  : %d%n", result.getNumber());
		
		var elements = result.toList();
		
		for(var dto : elements) {
			System.out.println(dto.getName());
		}
	
	}
}
