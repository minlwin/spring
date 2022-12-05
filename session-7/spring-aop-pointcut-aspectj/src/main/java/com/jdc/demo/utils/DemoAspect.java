package com.jdc.demo.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class DemoAspect {
	
	@Before("CommonPointCuts.memberDaoClasses() && CommonPointCuts.searchMethods()")
	void beforeLog(JoinPoint joinPoint) {
		System.out.println("Before Advice");
		System.out.println("--------------------------");
		System.out.printf("%-16s : %s%n".formatted("Target Class", joinPoint.getTarget().getClass().getSimpleName()));
		System.out.printf("%-16s : %s%n".formatted("Target Method", joinPoint.getSignature().getName()));
		System.out.println("--------------------------");
	}
}
