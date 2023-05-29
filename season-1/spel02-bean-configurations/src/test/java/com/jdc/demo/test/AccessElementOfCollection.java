package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.CollectionDemoConfig;

@SpringJUnitConfig(classes = CollectionDemoConfig.class)
public class AccessElementOfCollection {

	@Value("#{@array[0]}")
	DayOfWeek firstDay;
	
	@Value("#{@list[0]}")
	Month firstMonth;
	
	@Value("#{@map['basic']}")
	String basic;
	
	@Test
	void demo() {
		assertEquals(DayOfWeek.MONDAY, firstDay);
		assertEquals(Month.JANUARY, firstMonth);
		assertEquals("Java Basic", basic);
	}
}
