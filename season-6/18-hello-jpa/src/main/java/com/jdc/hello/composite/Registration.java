package com.jdc.hello.composite;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Registration implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RegistrationPK id;
	private String student;
	private String course;

	public RegistrationPK getId() {
		return id;
	}

	public void setId(RegistrationPK id) {
		this.id = id;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
