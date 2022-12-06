package com.jdc.tx.demo.model.dto;

import java.time.LocalDateTime;

public record TransferLog(
		int id,
		LocalDateTime transfer_at,
		int account_trom,
		String fromName,
		int account_to,
		String toName,
		int amount,
		boolean success,
		String message
		) {

}
