package com.jdc.spring.locations.model.dto;

public record State(
		int id,
		String name,
		String burmese,
		String capital,
		String region,
		String type
		) {

	public State withId(int id) {
		return new State(id, name, burmese, capital, region, type);
	}

}
