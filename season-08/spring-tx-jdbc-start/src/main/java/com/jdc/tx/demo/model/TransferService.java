package com.jdc.tx.demo.model;

import org.springframework.transaction.annotation.Transactional;

import com.jdc.tx.demo.model.dto.TransferForm;
import com.jdc.tx.demo.model.dto.TransferLog;

public interface TransferService {

	@Transactional(noRollbackFor = TransferServiceException.class)
	TransferLog transfer(TransferForm form);
}
