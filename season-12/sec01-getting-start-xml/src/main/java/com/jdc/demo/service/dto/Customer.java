package com.jdc.demo.service.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Customer {

	private String email;
	private String name;
	private String password;
	private String phone;
	private boolean activated;
	private boolean locked;
	private Date validpass;
	private Date retired;
}
