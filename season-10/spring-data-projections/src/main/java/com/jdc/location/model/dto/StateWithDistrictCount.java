package com.jdc.location.model.dto;

public interface StateWithDistrictCount {

	int getId();
	String getName();
	int getDistrictCount();
	
	default void show() {
		System.out.printf("ID: %2d, Name: %-12s, District: %d%n",
				getId(), getName(), getDistrictCount());
	}
}
