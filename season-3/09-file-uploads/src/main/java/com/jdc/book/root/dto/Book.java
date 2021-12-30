package com.jdc.book.root.dto;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Book {

	private int id;
	@NotBlank(message = "{book.title.notBlank}")
	private String title;
	@NotBlank(message = "{book.author.notBlank}")
	private String author;
	@NotNull(message = "{book.category.notNull}")
	private Category category;
	@Min(value = 3000, message = "{book.price.min}")
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
