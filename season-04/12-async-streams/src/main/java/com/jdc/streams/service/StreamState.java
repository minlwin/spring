package com.jdc.streams.service;

public class StreamState {
	
	private volatile boolean complete;
	
	public synchronized void setComplete() {
		complete = true;
	}
	
	public synchronized boolean isComplete() {
		return complete;
	}

}
