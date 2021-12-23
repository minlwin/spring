package com.jdc.mappings.model.dto;

import java.util.Objects;

public class Course {

	private int id;
	private String name;
	private Level level;
	private int duration;
	private int fees;

	public Course(String name, Level level, int duration, int fees) {
		super();
		this.name = name;
		this.level = level;
		this.duration = duration;
		this.fees = fees;
	}

	public Course() {
	}

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

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
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
		return duration == other.duration && fees == other.fees && id == other.id && level == other.level
				&& Objects.equals(name, other.name);
	}

}
