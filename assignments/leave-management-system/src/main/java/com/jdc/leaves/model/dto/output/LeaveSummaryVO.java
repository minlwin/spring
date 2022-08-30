package com.jdc.leaves.model.dto.output;

public class LeaveSummaryVO {

	public LeaveSummaryVO() {
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

}