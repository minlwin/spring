package com.jdc.book.root.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.book.root.dto.Book;
import com.jdc.book.root.dto.Category;

@Service
public class FileUploadService {

	@Autowired
	private CategoryService categories;
	@Autowired
	private BookService books;

	public String upload(MultipartFile file) {

		var uploadBooks = readLines(file);
		
		var categoryBooksMap = uploadBooks.stream()
				.collect(Collectors.groupingBy(a -> a.getCategory().getName()));
		
		for(var entry : categoryBooksMap.entrySet()) {
			
			var category = categories.getCategory(entry.getKey());
			
			for(var book : entry.getValue()) {
				book.setCategory(category);
				books.save(book);
			}
			
		}

		return "% books has been uploaded!".formatted(uploadBooks.size());
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
