package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.AppConfig;
import com.jdc.demo.ImageFileProvider;

@SpringJUnitConfig(classes = AppConfig.class)
public class ElConfigurationTest {

	@Autowired
	private ImageFileProvider fileProvider;
	
	@Test
	void demo() {
		assertNotNull(fileProvider);
		assertEquals(System.getProperty("user.home"), fileProvider.getBaseDirectory());
	}
}
