package com.jdc.leaves.model.dto.output;

import java.util.Objects;

public class StudentListVO {

	public StudentListVO() {
	}

	public StudentListVO(int id, String name, String phone, String email, String education, long classCount) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.education = education;
		this.classCount = classCount;
	}

	private int id;

	private String name;

	private String phone;

	private String email;

	private String education;

	private long classCount;

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

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public long getClassCount() {
		return classCount;
	}

	public void setClassCount(long classCount) {
		this.classCount = classCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classCount, education, email, id, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentListVO other = (StudentListVO) obj;
		return classCount == other.classCount && Objects.equals(education, other.education)
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}


}