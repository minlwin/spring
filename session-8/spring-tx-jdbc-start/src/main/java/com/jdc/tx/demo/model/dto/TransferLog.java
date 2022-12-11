package com.jdc.tx.demo.model.dto;

import java.time.LocalDateTime;

public record TransferLog(
		int id,
		int amount,
		AccountHistory from,
		AccountHistory to,
		LocalDateTime transferAt
		) {

}
