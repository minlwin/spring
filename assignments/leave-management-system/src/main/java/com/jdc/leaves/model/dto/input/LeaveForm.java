package com.jdc.leaves.model.dto.input;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class LeaveForm {
	
	public LeaveForm() {
	}
	
	public LeaveForm(int classId, int student, LocalDate applyDate, LocalDate startDate, int days, String reason) {
		super();
		this.classId = classId;
		this.student = student;
		this.applyDate = applyDate;
		this.startDate = startDate;
		this.days = days;
		this.reason = reason;
	}

	private int classId;

	private int student;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate applyDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	private int days;

	private String reason;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getStudent() {
		return student;
	}

	public void setStudent(int student) {
		this.student = student;
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

	public LocalDate getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(LocalDate applyDate) {
		this.applyDate = applyDate;
	}	
}