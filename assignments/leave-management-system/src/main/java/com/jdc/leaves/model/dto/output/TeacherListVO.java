package com.jdc.leaves.model.dto.output;

import java.time.LocalDate;
import java.util.Objects;

import com.jdc.leaves.model.dto.input.TeacherForm;

public class TeacherListVO {

	public TeacherListVO() {
	}
	
	public TeacherListVO(int id, String name, String phone, String email, LocalDate assignDate, long classCount) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.assignDate = assignDate;
		this.classCount = classCount;
	}

	private int id;

	private String name;

	private String phone;

	private String email;

	private LocalDate assignDate;

	private long classCount;
	
	public TeacherForm form() {
		return new TeacherForm(id, name, phone, email, assignDate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(LocalDate assignDate) {
		this.assignDate = assignDate;
	}

	public long getClassCount() {
		return classCount;
	}

	public void setClassCount(long classCount) {
		this.classCount = classCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignDate, classCount, email, id, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherListVO other = (TeacherListVO) obj;
		return Objects.equals(assignDate, other.assignDate) && classCount == other.classCount
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}
}