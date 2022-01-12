package com.jdc.streams;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan("com.jdc.streams.service")
public class RootConfig {

	@Bean
	public TaskExecutor executor() {
		var executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(25);
		return executor;
	}
}
