package com.jdc.tx.demo.model.dto;

import java.time.LocalDate;

public record TransferForm(
		int from,
		int to,
		int amount,
		LocalDate at
		) {

}
