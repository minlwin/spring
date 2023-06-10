package com.jdc.scope.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StringCart implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<String> list;
	
	public StringCart() {
		list = new ArrayList<>();
	}
	
	public void add(String data) {
		list.add(data);
	}
	
	public List<String> getList() {
		return list;
	}
	
	public int getCount() {
		return list.size();
	}
}
