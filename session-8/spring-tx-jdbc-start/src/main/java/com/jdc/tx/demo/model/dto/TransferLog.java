package com.jdc.tx.demo.model.dto;

import java.time.LocalDateTime;

public record TransferLog(
		int id,
		LocalDateTime transferTime,
		int accountFrom,
		int accountTo,
		int amount,
		boolean success,
		String message
		) {

}
