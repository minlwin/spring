package com.jdc.leaves.model.dto.output;

import java.time.LocalDate;
import java.util.Objects;

public class LeaveListVO {

	public LeaveListVO() {
	}

	public LeaveListVO(LocalDate applyDate, int classId, int studentId, String student, String studentPhone,
			int teacherId, String teacher, LocalDate startDate, int days, String reason) {
		super();
		this.applyDate = applyDate;
		this.classId = classId;
		this.studentId = studentId;
		this.student = student;
		this.studentPhone = studentPhone;
		this.teacherId = teacherId;
		this.teacher = teacher;
		this.startDate = startDate;
		this.days = days;
		this.reason = reason;
	}

	private LocalDate applyDate;

	private int classId;

	private int studentId;

	private String student;

	private String studentPhone;

	private int teacherId;

	private String teacher;

	private LocalDate startDate;

	private int days;

	private String reason;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public LocalDate getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(LocalDate applyDate) {
		this.applyDate = applyDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public int hashCode() {
		return Objects.hash(applyDate, classId, days, reason, startDate, student, studentId, studentPhone, teacher,
				teacherId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeaveListVO other = (LeaveListVO) obj;
		return Objects.equals(applyDate, other.applyDate) && classId == other.classId && days == other.days
				&& Objects.equals(reason, other.reason) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(student, other.student) && studentId == other.studentId
				&& Objects.equals(studentPhone, other.studentPhone) && Objects.equals(teacher, other.teacher)
				&& teacherId == other.teacherId;
	}

}