package com.jdc.leaves.model.dto.output;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

public class LeaveSummaryVO {

	public LeaveSummaryVO() {
	}

	public LeaveSummaryVO(ClassListVO vo) {
		super();
		this.classId = vo.getId();
		this.teacher = vo.getTeacherName();
		this.startDate = vo.getStartDate();
		this.students = vo.getStudentCount();
		this.details = vo.getDescription();
	}

	private int classId;

	private String teacher;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	private long students;

	private long leaves;
	
	private String details;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
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

	public long getStudents() {
		return students;
	}

	public void setStudents(long students) {
		this.students = students;
	}

	public long getLeaves() {
		return leaves;
	}

	public void setLeaves(long leaves) {
		this.leaves = leaves;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classId, details, leaves, startDate, students, teacher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeaveSummaryVO other = (LeaveSummaryVO) obj;
		return classId == other.classId && Objects.equals(details, other.details) && leaves == other.leaves
				&& Objects.equals(startDate, other.startDate) && students == other.students
				&& Objects.equals(teacher, other.teacher);
	}
}