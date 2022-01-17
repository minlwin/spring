package com.jdc.security.services.model;

import jakarta.validation.constraints.NotBlank;

public class SignUpDto {

	@NotBlank(message = "Enter Member Name.")
	private String name;
	@NotBlank(message = "Enter Login Id.")
	private String loginId;
	@NotBlank(message = "Enter Password.")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
