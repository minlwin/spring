package com.jdc.leaves.model.dto.input;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class LeaveForm {

	public LeaveForm() {
	}

	public LeaveForm(int classId, int student) {
		super();
		this.classId = classId;
		this.student = student;
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

	@NotNull(message = "Please enter leave start date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@Min(value = 1, message = "Please enter leave days.")
	private int days;

	@NotEmpty(message = "Please enter reason for leaves.")
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
	
	public Map<String, Object> leavesInsertParams() {
		return Map.of(
			"apply_date", Date.valueOf(applyDate),
			"classes_id", classId,
			"student_id", student,
			"start_date", Date.valueOf(startDate),
			"days", days,
			"reason", reason
		);
	}
	
	public List<Map<String, Object>> leavesDaysInsertParams() {
		return IntStream.iterate(0, a -> a + 1).limit(days)
			.mapToObj(a -> startDate.plusDays(a))
			.map(this::leavesDaysInsertParams)
			.toList();
	}
	
	private Map<String, Object> leavesDaysInsertParams(LocalDate leaveDate) {
		return Map.of(
				"leaves_apply_date", Date.valueOf(applyDate),
				"leaves_classes_id", classId,
				"leaves_student_id", student,
				"leave_date", leaveDate
		);
	}
}