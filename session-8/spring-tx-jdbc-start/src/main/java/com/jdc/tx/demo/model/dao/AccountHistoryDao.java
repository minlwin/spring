package com.jdc.tx.demo.model.dao;

import org.springframework.stereotype.Repository;

import com.jdc.tx.demo.model.dto.Account;
import com.jdc.tx.demo.model.dto.AccountHistory;

@Repository
public class AccountHistoryDao {

	public AccountHistory debit(int transferId, Account fromAccount, int amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountHistory credit(int transferId, Account toAccount, int amount) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
