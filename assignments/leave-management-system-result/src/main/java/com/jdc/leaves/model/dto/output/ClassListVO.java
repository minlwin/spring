package com.jdc.leaves.model.dto.output;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

public class ClassListVO {

	public ClassListVO() {
	}
	
	public ClassListVO(int id, int teacherId, String teacherName, String teacherPhone, LocalDate startDate, int months,
			String description, long studentCount) {
		super();
		this.id = id;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherPhone = teacherPhone;
		this.startDate = startDate;
		this.months = months;
		this.description = description;
		this.studentCount = studentCount;
	}


	private int id;

	private int teacherId;

	private String teacherName;

	private String teacherPhone;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	private int months;

	private String description;

	private long studentCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(long studentCount) {
		this.studentCount = studentCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, months, startDate, studentCount, teacherId, teacherName, teacherPhone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassListVO other = (ClassListVO) obj;
		return Objects.equals(description, other.description) && id == other.id && months == other.months
				&& Objects.equals(startDate, other.startDate) && studentCount == other.studentCount
				&& teacherId == other.teacherId && Objects.equals(teacherName, other.teacherName)
				&& Objects.equals(teacherPhone, other.teacherPhone);
	}


}