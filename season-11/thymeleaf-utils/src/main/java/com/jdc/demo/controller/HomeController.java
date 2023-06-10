package com.jdc.demo.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	String index() {
		return "home";
	}

	@GetMapping("dates")
	String dateTime() {
		return "dates";
	}

	@GetMapping("objects")
	String objects(ModelMap model) {
		model.put("nullValue", null);
		model.put("notNullValue", "This is not null");
		return "objects";
	}

	@GetMapping("bools")
	String bools() {
		return "bools";
	}

	@GetMapping("numbers")
	String numbers() {
		return "numbers";
	}

	@GetMapping("strings")
	String strings(ModelMap model) {
		model.put("escapeXML", "<hello />");
		model.put("escapeString", "\"Hello\' \t \r \\ Java\"");
		return "strings";
	}

	@GetMapping("collections")
	String collections(ModelMap model) {

		Comparator<Integer> reverse = (o1, o2) -> o2 - o1;
		model.put("reverseSort", reverse);

		return "collections";
	}

	@GetMapping("others")
	String otherUtils(ModelMap model) {
		model.put("subjects", List.of("Java", "Spring", "Angular", "Flutter"));
		return "others";
	}
}
