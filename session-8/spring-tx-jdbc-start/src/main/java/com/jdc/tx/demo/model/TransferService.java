package com.jdc.tx.demo.model;

import com.jdc.tx.demo.model.dto.TransferForm;
import com.jdc.tx.demo.model.dto.TransferLog;

public interface TransferService {

	TransferLog transfer(TransferForm form);
}
