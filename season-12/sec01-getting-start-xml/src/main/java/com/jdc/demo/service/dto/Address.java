package com.jdc.demo.service.dto;

import lombok.Data;

@Data
public class Address {

	private int id;
	private String email;
	private String name;
	private String building;
	private String street;
	private String township;
	private String division;

}
