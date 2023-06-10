package com.jdc.tx.demo.model.dto;

import java.time.LocalDateTime;

public record TransferForm(
		int account_from,
		int account_to,
		int amount,
		LocalDateTime transfer_at
		) {

}
