package com.jdc.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MyConcerns {
	
	@Before("execution(void hello())")
	void beforeLog() {
		System.out.println("Before Execution");
	}
	
}
