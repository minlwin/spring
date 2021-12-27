package com.jdc.form.model.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserInput {

	private int id;
	private String name;
	private String phone;
	private String email;
	private String password;
	private Course course;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registration;
	
	private Gender gender;
	
	private String [] foundations;
	
	private String remark;
	
	private boolean agree;
	
	public enum Gender {
		Male, Female
	}
}
