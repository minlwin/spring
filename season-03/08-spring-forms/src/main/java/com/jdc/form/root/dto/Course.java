package com.jdc.form.root.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class Course {

	@NonNull
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private Integer fees;
	
}
