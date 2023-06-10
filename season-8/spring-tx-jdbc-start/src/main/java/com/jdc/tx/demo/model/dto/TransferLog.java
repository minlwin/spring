package com.jdc.tx.demo.model.dto;

import java.time.LocalDateTime;

public record TransferLog(
		int id,
		int amount,
		AccountHistory from,
		AccountHistory to,
		LocalDateTime transferAt,
		boolean status,
		String message
		) {

	public static TransferLog from(int transferId, int amount, AccountHistory fromHistory, AccountHistory toHistory,
			LocalDateTime at) {
		return new TransferLog(transferId, amount, fromHistory, toHistory, at, true, null);
	}

}
