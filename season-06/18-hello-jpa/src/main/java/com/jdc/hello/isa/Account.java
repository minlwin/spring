package com.jdc.hello.isa;

import static javax.persistence.InheritanceType.JOINED;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance(strategy = JOINED)
public abstract class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	private String password;
	private Role role;

	public enum Role {
		Admin, Teacher, Student
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
