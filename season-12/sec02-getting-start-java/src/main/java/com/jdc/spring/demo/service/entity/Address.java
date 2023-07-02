package com.jdc.spring.demo.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "email", referencedColumnName = "email")
	private Customer customer;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String building;
	@Column(nullable = false)
	private String street;
	@Column(nullable = false)
	private String township;
	@Column(nullable = false)
	private String division;

}
