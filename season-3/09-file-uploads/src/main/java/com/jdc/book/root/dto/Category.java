package com.jdc.book.root.dto;

import lombok.Data;

@Data
public class Category {

	private int id;
	private String name;

	public Category() {
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
