package com.jdc.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MyConcerns {
	
	@Before("bean(myService)")
	void beforeLog() {
		System.out.println("Before Execution");
	}
	
	@AfterReturning("bean(myService)")
	void afterReturning() {
		System.out.println("Return A Value");
	}
	
	@AfterThrowing("bean(myService)")
	void afterThrowing() {
		System.out.println("After Throwing an exception");
	}
	
	@After("bean(myService)")
	void afterAll() {
		System.out.println("After Finally");
	}
	
	@Around("bean(myService)")
	Object aroundInvoke(ProceedingJoinPoint joinPoint) {
		
		Object result = null;
		System.out.println("Around before invoke");
		try {
			result = joinPoint.proceed();
			System.out.println("Around after returning");
		} catch (Throwable e) {
			System.out.println("Around after throwing");
			throw new RuntimeException(e);
		} finally {
			System.out.println("Around finally");
		}
		
		return result;
	}
	
}
