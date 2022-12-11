package com.jdc.tx.demo.model.dto;

public record AccountHistory(
	int id,
	int transfer_id,
	int account_id,
	String account_name,
	Type type,
	int before_amount,
	int amount) {

	public enum Type {
		Credit, Debit
	}
}
