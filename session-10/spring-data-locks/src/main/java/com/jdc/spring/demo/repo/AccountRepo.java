package com.jdc.spring.demo.repo;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.spring.demo.entity.Account;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;

public interface AccountRepo extends JpaRepositoryImplementation<Account, Integer>{

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints({
		@QueryHint(name = "jakarta.persistence.lock.timeout", value = "0")
	})
	@Query("select a from Account a where a.code = ?1")
	Account findOneAndLockNoWait(int code);
	
}
