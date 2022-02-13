package com.jdc.hello.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.hello.Message;

public class HelloJpaTest {
	
	private static EntityManagerFactory EMF;

	@BeforeAll
	public static void beforeStart() {
		EMF = Persistence.createEntityManagerFactory("18-hello-jpa");
	}
	
	@AfterAll
	public static void shutDown() {
		EMF.close();
	}
	
	@Test
	void test() {
		
		var em = EMF.createEntityManager();
		
		em.getTransaction().begin();
		
		var message = new Message();
		message.setUser("Min Lwin");
		message.setMessage("Hello Hibernate JPA.");
		
		em.persist(message);
		
		em.getTransaction().commit();
		
		Assertions.assertEquals(1, message.getId());
		
	}
}
