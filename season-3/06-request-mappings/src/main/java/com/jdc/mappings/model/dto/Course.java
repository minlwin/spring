package com.jdc.mappings.model.dto;

import java.util.Objects;

public class Course {

	private int id;
	private String name;
	private String duration;
	private String level;
	private String fees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duration, fees, id, level, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(duration, other.duration) && Objects.equals(fees, other.fees) && id == other.id
				&& Objects.equals(level, other.level) && Objects.equals(name, other.name);
	}

}
