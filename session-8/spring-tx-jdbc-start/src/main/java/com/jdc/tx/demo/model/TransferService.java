package com.jdc.tx.demo.model;

import com.jdc.tx.demo.model.dto.TransferLog;
import com.jdc.tx.demo.model.dto.form.TransferForm;

public interface TransferService {

	TransferLog transfer(TransferForm form);
}
