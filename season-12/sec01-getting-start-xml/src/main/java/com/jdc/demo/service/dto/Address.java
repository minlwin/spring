package com.jdc.demo.service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Address {

	private int id;
	private String email;
	
	@NotBlank(message = "Please enter name.")
	private String name;
	@NotBlank(message = "Please enter building address.")
	private String building;
	@NotBlank(message = "Please enter street address.")
	private String street;
	@NotBlank(message = "Please enter township.")
	private String township;
	@NotBlank(message = "Please enter division.")
	private String division;

}
