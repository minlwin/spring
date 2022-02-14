package com.jdc.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RelationshipTest {
	
	static EntityManagerFactory EMF;

	@BeforeAll
	static void before() {
		EMF = Persistence.createEntityManagerFactory("19-relationships");
	}
	
	@AfterAll
	static void after() {
		EMF.close();
	}
	
	@Test
	void test() {
		
	}
}
