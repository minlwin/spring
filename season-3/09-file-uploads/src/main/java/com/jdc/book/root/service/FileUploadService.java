package com.jdc.book.root.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.book.root.dto.Book;
import com.jdc.book.root.dto.Category;

@Service
public class FileUploadService {

	@Autowired
	private CategoryService categories;
	@Autowired
	private BookService books;
	
	@Autowired
	private Validator validator;

	@Transactional
	public String upload(MultipartFile file) {

		var uploadBooks = readLines(file);
		
		var categoryBooksMap = uploadBooks.stream()
				.collect(Collectors.groupingBy(a -> a.getCategory().getName()));
		
		for(var entry : categoryBooksMap.entrySet()) {
			
			var category = categories.getCategory(entry.getKey());
			
			for(var book : entry.getValue()) {
				book.setCategory(category);
				var result = new BeanPropertyBindingResult(book, "target");
				
				validator.validate(book, result);
				
				if(result.hasErrors()) {
					var message = result.getFieldErrors().stream().map(a -> a.getDefaultMessage()).findAny().get();
					throw new FileUploadAppException(message);
				}
				
				books.save(book);
			}
			
		}

		return "%d books has been uploaded!".formatted(uploadBooks.size());
	}

	private List<Book> readLines(MultipartFile file) {
		List<Book> list = new ArrayList<>();

		try (var reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			String line = null;

			while (null != (line = reader.readLine())) {
				var book = readBook(line);
				list.add(book);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	private Book readBook(String line) {

		var array = line.split("\t");
		if (array.length < 4 && array.length > 5) {
			// throw error
		}

		var book = new Book();
		book.setTitle(array[0].trim());
		book.setAuthor(array[1].trim());
		book.setCategory(new Category(array[2].trim()));
		book.setPrice(Integer.parseInt(array[3].trim()));
		
		if(array.length > 4) {
			book.setRemark(array[4].trim());
		}

		return book;
	}

}
