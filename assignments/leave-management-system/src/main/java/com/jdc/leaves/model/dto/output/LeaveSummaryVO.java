package com.jdc.leaves.model.dto.output;

import java.util.Objects;

public class LeaveSummaryVO {

	public LeaveSummaryVO() {
	}

	public LeaveSummaryVO(int classId, String teacher, String startDate, long students, long leaves) {
		super();
		this.classId = classId;
		this.teacher = teacher;
		this.startDate = startDate;
		this.students = students;
		this.leaves = leaves;
	}

	private int classId;

	private String teacher;

	private String startDate;

	private long students;

	private long leaves;

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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
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

	@Override
	public int hashCode() {
		return Objects.hash(classId, leaves, startDate, students, teacher);
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
		return classId == other.classId && leaves == other.leaves && Objects.equals(startDate, other.startDate)
				&& students == other.students && Objects.equals(teacher, other.teacher);
	}

}