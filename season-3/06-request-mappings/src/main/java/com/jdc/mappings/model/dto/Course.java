package com.jdc.mappings.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {

	private int id;
	@NonNull
	private String name;
	@NonNull
	private Level level;
	@NonNull
	private Integer duration;
	@NonNull
	private Integer fees;

}
