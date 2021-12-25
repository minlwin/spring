package com.jdc.scope.model;

import java.io.Serializable;

public class Counter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int count;
	
	public int countUp() {
		return ++ count;
	}
	
	public int getCount() {
		return count;
	}

}
