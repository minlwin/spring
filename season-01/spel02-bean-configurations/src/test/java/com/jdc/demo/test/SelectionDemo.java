package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Month;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.CollectionDemoConfig;

@SpringJUnitConfig(classes = CollectionDemoConfig.class)
public class SelectionDemo {

	@Value("#{@list.?[maxLength() eq 30]}")
	List<Month> result;
	
	@Value("#{@map.?[value.startsWith('Java')]}")
	Map<String, String> selectedMap;
	
	@Value("#{@list.![name()]}")
	List<String> projectedList;
	
	@Value("#{@list.?[maxLength() eq 31].![name()]}")
	List<String> selectedAndProjectedList;
	
	@Test
	void demo() {
		assertEquals(4, result.size());
		assertEquals(1, selectedMap.size());
		
		for(var data : selectedAndProjectedList) {
			System.out.println(data);
		}
	}
}
