package com.jdc.location.model.dto;

import com.jdc.location.model.entity.State.Type;

public interface StateIdDipslayName {

	int getId();
	String getName();
	Type getType();
	
	default String getDisplayName() {
		return "%s %s".formatted(getName(), getType());
	}
}
