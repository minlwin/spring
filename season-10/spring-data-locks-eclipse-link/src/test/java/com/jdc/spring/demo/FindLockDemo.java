package com.jdc.spring.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.demo.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class FindLockDemo {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	void lockDemo() {
		
		var entity = em.find(Account.class, 1, LockModeType.PESSIMISTIC_WRITE);
		entity.setName("Update Name");
	}
}
