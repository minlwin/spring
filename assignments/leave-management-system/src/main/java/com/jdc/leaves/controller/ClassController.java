package com.jdc.leaves.controller;

import java.time.LocalDate;
import java.util.Optional;

import com.jdc.leaves.model.dto.input.ClassForm;
import com.jdc.leaves.model.dto.input.RegistrationForm;

public class ClassController {

	public ClassController() {
	}

	public String index(Optional<String> teacher, Optional<LocalDate> from, Optional<LocalDate> to) {
		// TODO implement here
		return "";
	}

	public String edit(Optional<Integer> id) {
		// TODO implement here
		return "";
	}

	public String save(ClassForm form) {
		// TODO implement here
		return "";
	}

	public String showDetails(int id) {
		// TODO implement here
		return "";
	}

	public String register(int id) {
		// TODO implement here
		return "";
	}

	public String saveRegistration(RegistrationForm form) {
		// TODO implement here
		return "";
	}

	public String showRegistrationDetails(int id) {
		// TODO implement here
		return "";
	}

}