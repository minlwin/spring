package com.jdc.demo.utils;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class DemoAdvisor implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Messages from Advisor");
		System.out.println("--------------------------");
		System.out.printf("%-16s : %s%n".formatted("Target Class", target.getClass().getSimpleName()));
		System.out.printf("%-16s : %s%n".formatted("Target Method", method.getName()));
		System.out.println("--------------------------");
	}

}
