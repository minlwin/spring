package com.jdc.demo.dto;

import java.time.LocalDate;

public record Classes(
		int id,
		Course course,
		LocalDate startDate,
		int months
		) {

}
