package com.jdc.spring.demo.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class AccountDto {

	private String email;
	private String name;
	private String password;
	private Role role;
	private Date expire_at;
	private boolean activated;
	private boolean locked;

	
	public enum Role {
		Admin, Member
	}
}
