package com.jdc.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import com.jdc.demo.dto.Result;

@Aspect
@Configuration
public class MyConcerns {
	
	@Before(value = "bean(myService) && args(value,*)", argNames = "value")
	void beforeLog(String value) {
		System.out.println("Before Execution");
		System.out.println("Value is %s".formatted(value));
	}
	
	@AfterReturning(
			pointcut = "bean(myService) && execution(com.jdc..Result *(..)) && args(name,count)",
			argNames = "result,name,count",
			returning = "result")
	void afterReturning(Result result, String name, int count) {
		System.out.println("Return A Value");
		
		System.out.println("Arg Name  : %s".formatted(name));
		System.out.println("Arg Count : %d".formatted(count));
		
		System.out.println(result);
	}
	
	@AfterThrowing(
			pointcut = "bean(myService) && args(a,b)",
			argNames = "ex,a,b",
			throwing = "ex")
	void afterThrowing(RuntimeException ex, int a, int b) {
		System.out.println("After Throwing an exception");
		
		System.out.println("Argument A : %d".formatted(a));
		System.out.println("Argument B : %d".formatted(b));
		
		System.out.println(ex.getClass().getSimpleName());
		
		System.out.println(ex.getMessage());
	}
	
	@After(value = "bean(myService) && args(*,number)", argNames = "number")
	void afterAll(int number) {
		System.out.println("After Finally");
		System.out.println("Count is %d.".formatted(number));
	}
	
	@Around(value = "bean(myService) && args(value,count)", argNames = "value,count")
	Object aroundInvoke(ProceedingJoinPoint joinPoint, String value, int count) {
		
		Object result = null;
		System.out.println("Around before invoke");
		
		System.out.println("Value is %s.".formatted(value));
		System.out.println("Count is %d.".formatted(count));
		
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
