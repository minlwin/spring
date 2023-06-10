package com.jdc.demo.utils.aspects;

import org.aspectj.lang.JoinPoint;

public class DemoAspect {

	public void beforeExecution(JoinPoint joinPoint) {
		
		var target = joinPoint.getTarget();
		var proxy = joinPoint.getThis();
		var args = joinPoint.getArgs();
		var name = joinPoint.getStaticPart().getSignature().getName();
		
		System.out.println("----------------------------");
		System.out.println("Before Method Execution");
		System.out.println("%-10s: %s".formatted("Target", 
				target.getClass().getSimpleName()));
		System.out.println("%-10s: %s".formatted("Proxy", 
				proxy.getClass().getSimpleName()));
		System.out.println("%-10s: %s".formatted("Method", name));
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < args.length; i++) {
			var arg = args[i];
			System.out.println("%d. %-10s:%s".formatted(i+ 1, 
					arg.getClass().getSimpleName(), arg));
		}
		System.out.println("----------------------------");
	}
}
