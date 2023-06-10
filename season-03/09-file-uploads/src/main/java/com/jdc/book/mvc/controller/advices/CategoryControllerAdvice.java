package com.jdc.book.mvc.controller.advices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jdc.book.root.dto.Category;
import com.jdc.book.root.service.CategoryService;

@ControllerAdvice
public class CategoryControllerAdvice {

	@Autowired
	private CategoryService service;
	
	@ModelAttribute("categories")
	public List<Category> categories() {
		return service.getAll();
	}
	
}
