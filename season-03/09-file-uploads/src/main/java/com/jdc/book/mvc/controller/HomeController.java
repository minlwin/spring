package com.jdc.book.mvc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.book.root.dto.Book;
import com.jdc.book.root.service.BookService;

@Controller
@RequestMapping({
	"/home", "/book"
})
public class HomeController {

	@Autowired
	private BookService service;
	
	@GetMapping
	String indes(
			@RequestParam(required = false) Integer category, 
			@RequestParam(required = false) String keyword,
			ModelMap model) {
		
		// search books with request parameters
		var list = service.search(category, keyword);
		
		// add search result to model
		model.put("list", list);
		
		return "home";
	}
	
	@GetMapping("edit")
	String edit() {
		return "book-edit";
	}
	
	@GetMapping("details")
	String details() {
		return "book-details";
	}
	
	@PostMapping
	String save(
			@Validated @ModelAttribute Book book, 
			BindingResult result, RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			return "book-edit";
		}
		
		var id = service.save(book);
		redirect.addAttribute("id", id);
		
		return "redirect:/book/details";
	}
	
	@ModelAttribute("book")
	public Book book(@RequestParam Optional<Integer> id) {
		return id.flatMap(a -> service.findById(a)).orElse(new Book());
	}
}
