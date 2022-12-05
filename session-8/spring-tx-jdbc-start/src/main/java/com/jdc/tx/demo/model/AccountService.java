package com.jdc.tx.demo.model;

import java.util.List;

import com.jdc.tx.demo.model.dto.AccountHistory;
import com.jdc.tx.demo.model.dto.TransferForm;

public interface AccountService {

	List<AccountHistory> searchByAccount(int accountId);
	void transfer(TransferForm form);
}
