package com.jdc.spring.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.demo.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PessimisticLockScope;

@SpringBootTest
public class QueryLockDemo {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Rollback(false)
	@Transactional
	void lockDemo() {
		
		var query = em.createQuery(
				"select a from Account a where a.email = ?1", Account.class);
		
		query.setParameter(1, "admin@gmail.com");
		query.setLockMode(LockModeType.PESSIMISTIC_WRITE);
		query.setHint("jakarta.persistence.lock.scope", PessimisticLockScope.EXTENDED);
		
		var result = query.getResultList();
		
		if(!result.isEmpty()) {
			result.get(0).setName("Update Name");
		}
	}
}
