package com.jdc.form.root.dto;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.jdc.form.mvc.validator.Phone;

import lombok.Data;

@Data
public class UserInput {

	private int id;
	
	@NotBlank(message = "{empty.employee.name}")
	private String name;
	
	@Phone(message = "{invalid.phone}", pattern = "09\\d([- ,]\\d{4}){2}")
	private String phone;
	@Email(message = "Invalid Email Address")
	private String email;
	private String password;
	@NotNull(message = "Please select course.")
	private Course course;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registration;
	
	private Gender gender;
	
	private String [] foundations;
	
	private String remark;
	
	@AssertTrue(message = "You have to aggree.")
	private boolean agree;
	
	public enum Gender {
		Male, Female
	}
}
