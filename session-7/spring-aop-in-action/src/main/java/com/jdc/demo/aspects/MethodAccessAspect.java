package com.jdc.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

import com.jdc.demo.dto.Student;

public class MethodAccessAspect {

	public void beforeExecution(String ... args) {
		System.out.println("Before Execution");	
		
		for(var arg : args) {
			System.out.println(arg);
		}
	}
	
	public void afterReturning(Student student) {
		System.out.println("After Returning");
		System.out.println(student);
	}
	
	public void afterThrowing( RuntimeException exception) {
		System.out.println("After Throwing");
		System.out.println(exception.getMessage());
	}
	
	public void afterFinally(String [] array) {
		System.out.println("After Finally");
		
		for(String str : array) {
			System.out.println(str);
		}
	}

	public Object arroundInvocation(ProceedingJoinPoint joinPoint) {
		
		Object result = null;
		
		try {
			
			// Before Execution
			System.out.println("Before Execution");
			
			result = joinPoint.proceed();
			
			// After Execution
			System.out.println("After Returning");

			return result;
		} catch (Throwable e) {
			// After Throwing
			System.out.println("After Throwing");
			throw new RuntimeException(e);
		} finally {
			// After Finally
			System.out.println("After Finally");
		}
		
	}
	
}
