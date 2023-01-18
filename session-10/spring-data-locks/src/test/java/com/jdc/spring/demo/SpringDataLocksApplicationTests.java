package com.jdc.spring.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.demo.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
class SpringDataLocksApplicationTests {
	
	@PersistenceContext
	private EntityManager em;

	@Test
	@Transactional
	@Rollback(false)
	void contextLoads() {
		
		var account = em.find(Account.class, 1, LockModeType.PESSIMISTIC_WRITE);
		
		account.setName(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss")));
		
	}

}
