package com.jdc.student.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.student.entity.Course;

@TestMethodOrder(OrderAnnotation.class)
public class EntityManagerTest {
	
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
	@Order(1)
	void initTest() {
		
		em.getTransaction().begin();
		
		// New or Transient State
		var course = new Course();
		
		// Managed State
		em.persist(course);
		
		course.setName("Java Basic Online");
		
		em.getTransaction().commit();
		
	}
	
	@Test
	@Order(2)
	void findTest() {
		var course = em.find(Course.class, 1);
		Assertions.assertEquals("Java Basic", course.getName());
		
		em.getTransaction().begin();
		course.setFees(20000);
		em.getTransaction().commit();	
	}
	
	@Test
	@Order(3)
	void getReferenceTest() {
		var course = em.getReference(Course.class, 2);
		Assertions.assertEquals("Full Stack Spring", course.getName());		
		
		em.getTransaction().begin();
		course.setFees(30000);
		em.getTransaction().commit();
	}
	
	@Test
	@Order(4)
	void notFoundTest() {
		// find
		Assertions.assertNull(em.find(Course.class, 5));
		// get reference
		var course = em.getReference(Course.class, 5);
		Assertions.assertNotNull(course);
		
		Assertions.assertThrows(EntityNotFoundException.class, 
				() -> course.getName());
	}
	
	@Test
	@Order(5)
	void detachTest() {
		
		var entity = em.find(Course.class, 3);
		
		em.getTransaction().begin();
		
		Assertions.assertTrue(em.contains(entity));
		
		em.clear();
		
		Assertions.assertFalse(em.contains(entity));
		
		entity.setMonths(5);
		
		em.merge(entity);
		
		em.getTransaction().commit();
	}
	
	@Test
	@Order(6)
	void removeTest() {
		
		var entity = em.find(Course.class, 1);
		
		Assertions.assertNotNull(entity);

		em.getTransaction().begin();
		
		em.remove(entity);
		
		em.getTransaction().commit();
		
		entity = em.find(Course.class, 1);
		
		Assertions.assertNull(entity);
	}
	
	@Test
	@Order(7)
	void persistanceContextTest() {
		
		// Thread 1
		new Thread(() -> {
			System.out.println("Start Thread 1");
			
			em.getTransaction().begin();
			var course = em.find(Course.class, 2);
			
			course.setName("Update From Thread 1");
			
			em.flush();
			
			em.getTransaction().commit();
			
		}).start();
		
		
		// Thread 2
		new Thread(() -> {
			System.out.println("Start Thread 2");
			
			var em = EMF.createEntityManager();
			
			var course = em.find(Course.class, 2);
			
			em.refresh(course);
			
			System.out.println(course.getName());
			
		}).start();
		
		System.out.println("End Test");

	}
	

}
