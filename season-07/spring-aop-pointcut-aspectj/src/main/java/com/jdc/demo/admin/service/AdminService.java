package com.jdc.demo.admin.service;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

	public void doOperation() {
		System.out.println("Admin Service Works");
	}
	
	public void doForAccount() {
		System.out.println("Admin Service using account");
	}

}
