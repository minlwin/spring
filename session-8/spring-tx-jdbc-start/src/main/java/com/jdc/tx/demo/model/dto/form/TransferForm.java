package com.jdc.tx.demo.model.dto.form;

import java.time.LocalDateTime;

public record TransferForm(
		int from,
		int to,
		int amount,
		LocalDateTime at
		) {

}
