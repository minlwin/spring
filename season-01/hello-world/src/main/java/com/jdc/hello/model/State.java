package com.jdc.hello.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State {

	@Id
	private int id;
	private String name;
	private String burmese;
	private String capital;
	private String region;
	private String type;

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

	public String getBurmese() {
		return burmese;
	}

	public void setBurmese(String burmese) {
		this.burmese = burmese;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
