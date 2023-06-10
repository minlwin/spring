package com.jdc.hello.config;

import static org.springframework.web.servlet.function.RouterFunctions.*;
import static org.springframework.web.servlet.function.ServerResponse.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import com.jdc.hello.config.dto.Message;


@Configuration
public class RouterConfig {

	@Bean
	public RouterFunction<ServerResponse> demo() {
		return route().GET("/router-demo", 
				req -> ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(new Message("Hello", "Hello From Router")))
				.build();
	}
}
