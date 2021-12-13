package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.DriverManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.locations.model.dao.StateDao;
import com.jdc.spring.locations.model.dto.State;

@TestMethodOrder(value = OrderAnnotation.class)
@SpringJUnitConfig(locations = "/application.xml")
class StateDaoTest {
	
	@Autowired
	@Qualifier("TestObject")
	private StateDao dao;
	
	@BeforeAll
	static void beforeClass() throws Exception{
		try (var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/location_db", "root", "admin")) {
			conn.createStatement().execute("truncate table state");
		}		
	}
	
	@Test
	@Order(1)
	void testCreate() {
		
		State state = new State(0, "Yangon", "Rangoon", "Yangon", "Center", "State");
		var result = dao.create(state);
		
		assertEquals(1, result.id());
		
	}
	
	@Test
	@Order(2)
	void testFindById() {
		var result = dao.findById(1);
		assertNotNull(result);

		result = dao.findById(2);
		assertNull(result);
	}

}
