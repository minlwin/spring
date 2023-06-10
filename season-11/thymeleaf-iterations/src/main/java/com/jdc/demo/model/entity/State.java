package com.jdc.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String region;
	private String capital;
	
	public State(String line) {
		var array = line.split("\t");
		this.name = array[0];
		this.region = array[1];
		this.capital = array[2];
	}
}
