package com.jdc.streams.service;

import java.io.IOException;
import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@Service
public class DataProvider {

	private final List<String> data;
	
	public DataProvider() {
		data = List.of(
				"Java Basic",
				"Spring",
				"Jakarta EE",
				"JavaFX",
				"Quarkus",
				"JavaScript",
				"TypeScript",
				"Angular",
				"React",
				"Kotlin",
				"Android",
				"Dart",
				"Flutter");
	}
	
	@Async
	public void stream(ResponseBodyEmitter emitter) {
		
		try {
			for(var data : this.data) {
				Thread.sleep(1000L);
				emitter.send(data);
			}
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		} finally {
			emitter.complete();
		}
		
	}
}
