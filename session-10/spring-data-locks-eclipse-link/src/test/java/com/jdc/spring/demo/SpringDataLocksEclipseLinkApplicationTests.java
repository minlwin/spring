package com.jdc.spring.demo;

import java.util.Map;

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
class SpringDataLocksEclipseLinkApplicationTests {
	
	@PersistenceContext
	private EntityManager em;

	@Test
	@Transactional
	@Rollback(false)
	void contextLoads() {
		
		var entity = em.find(Account.class, 1);
		
		em.lock(
			entity, 
			LockModeType.PESSIMISTIC_WRITE,
			Map.of("jakarta.persistence.lock.scope", PessimisticLockScope.NORMAL)
		);
		
		entity.setName("Update Name");
	}

}
