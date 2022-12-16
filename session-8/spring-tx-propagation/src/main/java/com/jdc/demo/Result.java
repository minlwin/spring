package com.jdc.demo;

import java.util.List;

public record Result(
		int headerId,
		List<Integer> detailsIds
		) {

}
