package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.ExpressionDemoConfig;

@SpringJUnitConfig(classes = ExpressionDemoConfig.class)
public class BeanReferenceTest {

	@Value("#{@today}")
	LocalDate now;
	
	@Test
	void demo() {
		assertNotNull(now);
		assertEquals(LocalDate.now(), now);
	}
}
