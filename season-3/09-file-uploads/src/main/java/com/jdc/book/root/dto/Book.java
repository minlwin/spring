package com.jdc.book.root.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Book {

	private int id;
	private String title;
	private String author;
	private Category category;
	private int price;
	private String remark;
	
	public Map<String, Object> getUpdateParams() {
		var map = getInsertParams();
		map.put("id", id);
		return map;
	}

	public Map<String, Object> getInsertParams() {
		var map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("author", author);
		map.put("price", price);
		map.put("remark", remark);
		map.put("category_id", category.getId());
		return map;
	}
}
