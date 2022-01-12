package com.jdc.streams;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
@ComponentScan("com.jdc.streams.service")
public class RootConfig {

	@Bean
	public AsyncTaskExecutor executor() {
		var executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(25);
		return executor;
	}
}
