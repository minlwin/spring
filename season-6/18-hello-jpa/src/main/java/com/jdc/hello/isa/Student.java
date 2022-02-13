package com.jdc.hello.isa;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Student extends Account {

	private static final long serialVersionUID = 1L;

	private LocalDate registration;
	private boolean active;

	public LocalDate getRegistration() {
		return registration;
	}

	public void setRegistration(LocalDate registration) {
		this.registration = registration;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
