package com.jdc.spring.demo.service.dto;

import com.jdc.spring.demo.service.entity.Address;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {

	private int id;
	
	@NotBlank(message = "Please enter name.")
	private String name;
	@NotBlank(message = "Please enter building address.")
	private String building;
	@NotBlank(message = "Please enter street address.")
	private String street;
	@NotBlank(message = "Please enter township.")
	private String township;
	@NotBlank(message = "Please enter division.")
	private String division;
	
	public Address entity() {
		var entity = new Address();
		entity.setName(name);
		entity.setBuilding(building);
		entity.setStreet(street);
		entity.setTownship(township);
		entity.setDivision(division);
		return entity;
	}
	
	public AddressDto(Address entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.building = entity.getBuilding();
		this.street = entity.getStreet();
		this.township = entity.getTownship();
		this.division = entity.getDivision();
	}
}
