package com.jdc.product.test;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.product.conf.ApplicationConfig;
import com.jdc.product.model.dao.CategoryDao;
import com.jdc.product.model.dao.ProductDao;
import com.jdc.product.model.dto.Product;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = ApplicationConfig.class)
public class ProductDaoTest {

	@Autowired
	private ProductDao dao;
	
	@Autowired
	private CategoryDao categories;
	
	@Test
	@Order(1)
	@DisplayName("1. Create Product Test")
	@Sql(statements = {
			"insert into category (name) values ('Foods')",
			"insert into category (name) values ('Drinks')"
	})
	void test1() {
		
		var category = categories.findById(1);
		var product = new Product();
		product.setCategory(category);
		product.setName("Pillow Pan");
		product.setPrice(600);
		
		var id = dao.create(product);
		assertEquals(1, id);
	}
	
	@Test
	@Order(2)
	@DisplayName("2. Find Product By Id")
	void test2() {
		
		var p = dao.findById(1);
		assertNotNull(p);
		
		assertEquals("Pillow Pan", p.getName());
		assertEquals("Foods", p.getCategory().getName());
		assertEquals(600, p.getPrice());
		
		assertNull(dao.findById(2));
	}
	
	@Test
	@Order(3)
	@DisplayName("3. Find Products By Category")
	void test3() {
		List<Product> list = dao.findByCategory(1);
		assertEquals(1, list.size());
		assertTrue(dao.findByCategory(2).isEmpty());
	}
	
	@Test
	@Order(4)
	@DisplayName("4. Search")
	void test4() {
		assertEquals(1, dao.search("foods").size());
		assertEquals(1, dao.search("PILLOW").size());
		assertTrue(dao.search("Pillows").isEmpty());
	}
	
	@Test
	@Order(5)
	@DisplayName("5. Update Product")
	void test5() {
		var p = dao.findById(1);
		p.setName("Pillow Bread");
		p.setPrice(700);
		
		int count = dao.update(p);
		assertEquals(1, count);
		
		var other = dao.findById(1);
		assertEquals(p.getName(), other.getName());
		assertEquals(p.getPrice(), other.getPrice());
	}
	
	@Test
	@Order(6)
	@DisplayName("6. Delete Product")
	void test6() {
		int count = dao.delete(1);
		assertEquals(1, count);
		assertNull(dao.findById(1));
	}
}
