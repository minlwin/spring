package com.jdc.demo.entity;

public class Address {

	private int id;
	private String building;
	private String street;
	private String township;
	
	public Address(int id, String building, String street, String township) {
		super();
		this.id = id;
		this.building = building;
		this.street = street;
		this.township = township;
	}

	public int getId() {
		return id;
	}

	public String getBuilding() {
		return building;
	}

	public String getStreet() {
		return street;
	}

	public String getTownship() {
		return township;
	}

}
