package com.jdc.demo.admin.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

	public void searchSomething() {
		System.out.println("Admin Dao Search");
	}
	
	public void saveSomething() {
		System.out.println("Save Operation of Admin Dao");
	}

}
