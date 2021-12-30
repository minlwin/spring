package com.jdc.book.root.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.book.root.dto.Book;

@Service
public class FileUploadService {

	@Autowired
	private CategoryService categories;
	@Autowired
	private BookService books;

	public String upload(InputStream inputStream) {

		var list = readLines(inputStream);

		for (var book : list) {
			books.save(book);
		}

		return "Upload OK!";
	}

	private List<Book> readLines(InputStream inputStream) {
		List<Book> list = new ArrayList<>();

		try (var reader = new BufferedReader(new InputStreamReader(inputStream))) {

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
		if (array.length != 5) {
			// throw error
		}

		var book = new Book();
		book.setTitle(array[0].trim());
		book.setAuthor(array[1].trim());
		book.setCategory(categories.getCategory(array[2].trim()));
		book.setPrice(Integer.parseInt(array[3].trim()));
		book.setRemark(array[4].trim());

		return book;
	}

}
