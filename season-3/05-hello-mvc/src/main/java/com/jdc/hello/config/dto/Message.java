package com.jdc.hello.config.dto;

import java.time.LocalDateTime;

public class Message {

	private String type;
	private String message;
	private LocalDateTime dateTime;

	public Message(String type, String message) {
		super();
		this.type = type;
		this.message = message;
		dateTime = LocalDateTime.now();
	}

	public String getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

}
