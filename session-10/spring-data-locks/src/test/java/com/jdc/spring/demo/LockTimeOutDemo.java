package com.jdc.spring.demo;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.demo.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class LockTimeOutDemo {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	void timeOutDemo() {
		
		var account = em.find(Account.class, 1);
		
		em.lock(account, LockModeType.PESSIMISTIC_WRITE, Map.of(
			"jakarta.persistence.lock.timeout", "0"));
		
		account.setName("Time Out Name");
		
	}
}
