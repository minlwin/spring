package com.jdc.tx.demo.model;

import java.sql.Timestamp;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.jdc.tx.demo.model.dto.TransferForm;

@Component
public class TransferOperationRollbakListener {
	
	private SimpleJdbcInsert insert;
	
	public TransferOperationRollbakListener(DataSource ds) {
		insert = new SimpleJdbcInsert(ds);
		insert.setTableName("transfer_log");
		insert.setGeneratedKeyName("id");
	}
	
	@Transactional
	@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
	public void onRollback(TransferForm form) {
		insert.execute(Map.of(	
				"account_from", form.account_from(),
				"account_to", form.account_to(),
				"amount", form.amount(),
				"transfer_at", Timestamp.valueOf(form.transfer_at()),
				"status", true,
				"message", "Fails Operation"
				));
	}
}
