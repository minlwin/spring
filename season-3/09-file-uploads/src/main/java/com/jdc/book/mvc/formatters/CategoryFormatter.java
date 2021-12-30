package com.jdc.book.mvc.formatters;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jdc.book.root.dto.Category;
import com.jdc.book.root.service.CategoryService;

@Component
public class CategoryFormatter implements Formatter<Category>{

	@Autowired
	private CategoryService service;

	@Override
	public String print(Category object, Locale locale) {
		return Optional.ofNullable(object).map(Category::getName).orElse("");
	}

	@Override
	public Category parse(String text, Locale locale) throws ParseException {
		return Optional.ofNullable(text)
				.filter(a -> StringUtils.hasLength(a))
				.map(Integer::parseInt)
				.flatMap(id -> service.findById(id)).orElse(null);
	}
}
