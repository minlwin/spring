package com.jdc.demo;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollectionDemoConfig {

	@Bean
	DayOfWeek[] array() {
		return DayOfWeek.values();
	}
	
	@Bean
	List<Month> list() {
		return List.of(Month.values());
	}
	
	@Bean
	Map<String, String> map() {
		var map = new HashMap<String, String>();
		map.put("basic", "Java Basic");
		map.put("advance", "Spring Framework");
		return map;
	}
}
