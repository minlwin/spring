package com.jdc.hello.config.dto;

import java.time.LocalDateTime;

public record Message(
		String type,
		String message,
		LocalDateTime dateTime
) {
	public Message(String type, String message) {
		this(type, message, LocalDateTime.now());
	}
}
