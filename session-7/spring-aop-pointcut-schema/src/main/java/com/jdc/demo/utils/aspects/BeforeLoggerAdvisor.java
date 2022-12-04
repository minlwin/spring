package com.jdc.demo.utils.aspects;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLoggerAdvisor implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {

		System.out.println("----------------------------");
		System.out.println("Before Method Execution");
		System.out.println("%-10s: %s".formatted("Target", 
				target.getClass().getSimpleName()));
		System.out.println("%-10s: %s".formatted("Method", method.getName()));
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < args.length; i++) {
			var arg = args[i];
			System.out.println("%d. %-10s:%s".formatted(i+ 1, 
					arg.getClass().getSimpleName(), arg));
		}
		System.out.println("----------------------------");
		
	}

}
