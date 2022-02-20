package com.jdc.registration;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ElementCollection;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@Entity
public class Classes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private LocalDate startDate;
	@ElementCollection
	private List<DayOfWeek> days;
	private LocalTime timeFrom;
	private LocalTime timeTo;
	
	@ManyToMany
	@JoinTable(name = "Registration", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students;

	private int fees;

	@ManyToOne
	private Course course;

	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public List<DayOfWeek> getDays() {
		return days;
	}

	public void setDays(List<DayOfWeek> days) {
		this.days = days;
	}

	public LocalTime getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(LocalTime timeFrom) {
		this.timeFrom = timeFrom;
	}

	public LocalTime getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(LocalTime timeTo) {
		this.timeTo = timeTo;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
