package com.jdc.location.model.dto;

import org.springframework.beans.factory.annotation.Value;

public interface StateValueDto {

	int getId();
	
	@Value("#{target.name + ' ' + target.type}")
	String getDisplayName();
}
