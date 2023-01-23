package com.jdc.spring.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.demo.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class NamedQueryLockDemo {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Rollback(false)
	@Transactional
	void lockDemo() {
		
		var query = em.createNamedQuery("Account.findByRole", Account.class);
		query.setParameter(1, "admin@gmail.com");
		
		var result = query.getResultList();
		
		if(!result.isEmpty()) {
			result.get(0).setName("Update Name");
		}
	}
}
