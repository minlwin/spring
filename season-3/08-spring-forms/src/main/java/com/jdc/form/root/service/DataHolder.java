package com.jdc.form.root.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.jdc.form.root.dto.UserInput;

@Service
@ApplicationScope
public class DataHolder {

	private List<UserInput> repository;
	
	public DataHolder() {
		repository = new ArrayList<>();
	}
	
	public void add(UserInput data) {
		repository.add(data);
	}
	
	public List<UserInput> getAllData() {
		return new ArrayList<>(repository);
	}
}
