package com.jdc.hello.sec;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Two {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sequence_two")
	@TableGenerator(name = "sequence_two", initialValue = 2000)
	private int id;
	private String value;

	public Two() {
	}

	public Two(String value) {
		super();
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
