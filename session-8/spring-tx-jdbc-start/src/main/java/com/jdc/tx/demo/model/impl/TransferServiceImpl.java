package com.jdc.tx.demo.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.tx.demo.model.TransferService;
import com.jdc.tx.demo.model.TransferServiceException;
import com.jdc.tx.demo.model.dao.AccountDao;
import com.jdc.tx.demo.model.dao.AccountHistoryDao;
import com.jdc.tx.demo.model.dao.TransferLogDao;
import com.jdc.tx.demo.model.dto.TransferForm;
import com.jdc.tx.demo.model.dto.TransferLog;

@Service
public class TransferServiceImpl implements TransferService{
	
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private TransferLogDao transferLogDao;
	@Autowired
	private AccountHistoryDao accountHistoryDao;

	@Override
	public TransferLog transfer(TransferForm form) {
		
		// Create Transfer Log
		var transferId = transferLogDao.create(form);
		
		// Find From Account
		var fromAccount = accountDao.findById(form.account_from());

		var updatedAmountForFromUser = fromAccount.amount() - form.amount();
		
		if(updatedAmountForFromUser < 0) {
			throw new TransferServiceException("Account has no enough amount to transfer.");
		}

		// Update From Account 
		accountDao.save(fromAccount.withAmount(updatedAmountForFromUser));
		
		// Create From Account History
		var fromHistory = accountHistoryDao.debit(transferId, fromAccount, form.amount());
		
		// Find To Account
		var toAccount = accountDao.findById(form.account_to());
		
		var updatedAmountForToUser = toAccount.amount() + form.amount();

		// Update To Account
		accountDao.save(toAccount.withAmount(updatedAmountForToUser));
		// Create To Account History
		var toHistory = accountHistoryDao.credit(transferId, toAccount, form.amount());
		
		return TransferLog.from(transferId, form.amount(), fromHistory, toHistory, form.transfer_at());
	}

}
