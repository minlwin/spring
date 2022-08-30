package com.jdc.leaves.model.dto.output;

public class RegistrationDetailsVO {

	public RegistrationDetailsVO() {
	}

	private ClassListVO classInfo;

	private StudentListVO student;

	public ClassListVO getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassListVO classInfo) {
		this.classInfo = classInfo;
	}

	public StudentListVO getStudent() {
		return student;
	}

	public void setStudent(StudentListVO student) {
		this.student = student;
	}

}