package com.jdc.spring.locations.model.dao;

import java.util.List;

import com.jdc.spring.locations.model.dto.State;

public interface StateDao {

	State create(State state);
	
	State findById(int id);
	
	List<State> search(String keyword);
	
}
