package com.jdc.hello.isa;

import static javax.persistence.FetchType.LAZY;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderBy;

@Entity
public class Teacher extends Account {

	private static final long serialVersionUID = 1L;

	private String phone;
	
	@CollectionTable(name = "teacher_course", joinColumns = @JoinColumn(name = "teacher", referencedColumnName = "email"))
	@ElementCollection(fetch = LAZY)
	@OrderBy("courses")
	private List<String> courses;
	
	@MapKeyColumn(name = "course")
	@ElementCollection
	private Map<String, Integer> map;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
	
	
}
