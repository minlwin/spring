package com.jdc.student.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.student.entity.Contact;
import com.jdc.student.entity.Student;

public class CascadeTest {

	static EntityManagerFactory EMF;
	EntityManager em;
	
	@BeforeAll
	static void beforeClass() {
		EMF = Persistence.createEntityManagerFactory("20-entity-manager");
	}
	
	@AfterAll
	static void aflterClass() {
		EMF.close();
	}
	
	@BeforeEach
	void createEentityManager() {
		em = EMF.createEntityManager();
	}
	
	@AfterEach
	void closeEntityManager() {
		if(em.isOpen()) {
			em.close();
		}
	}
	
	@Test
	void cascadeTest() {
		
		em.getTransaction().begin();
		
		Contact contact = new Contact();
		contact.setEmail("aungaung@gmail.com");
		contact.setPhone("0988766788889");
		
		Student student = new Student();
		student.setName("Aung Aung");
		student.setContact(contact);
		
		em.persist(student);
		
		em.getTransaction().commit();
		
	}
}
