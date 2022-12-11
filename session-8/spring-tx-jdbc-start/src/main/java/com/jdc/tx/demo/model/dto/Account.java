package com.jdc.tx.demo.model.dto;

public record Account(
		int id,
		String name,
		String email,
		int amount
		) {

	public Account withAmount(int amount) {
		return new Account(id, name, email, amount);
	}

}
