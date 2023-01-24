package com.jdc.spring.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.demo.repo.AccountRepo;

@SpringBootTest
public class LockWithRepositoryMethods {

	@Autowired
	private AccountRepo repo;
	
	@Test
	@Transactional
	void lockDemo() {
		
		var entity = repo.findOneAndLockNoWait(1);
		
		entity.setName("Repo Update");
	}
}
