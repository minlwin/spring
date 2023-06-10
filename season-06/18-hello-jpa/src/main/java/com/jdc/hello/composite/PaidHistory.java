package com.jdc.hello.composite;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(value = PaidPK.class)
public class PaidHistory implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "paid_date")
	private LocalDate date;
	@Id
	@Column(name = "paid_seq")
	private int seq;

	private String student;
	private String course;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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
