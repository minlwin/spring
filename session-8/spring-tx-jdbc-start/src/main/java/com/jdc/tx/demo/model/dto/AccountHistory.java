package com.jdc.tx.demo.model.dto;

import java.time.LocalDateTime;

public record AccountHistory(
	int id,
	int transferId,
	int accountId,
	String accountName,
	Type type,
	int beforeAmount,
	int amount,
	LocalDateTime issueAt) {

	public enum Type {
		Credit, Debit
	}
}
