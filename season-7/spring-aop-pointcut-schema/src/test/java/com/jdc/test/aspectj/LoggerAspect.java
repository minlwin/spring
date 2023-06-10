package com.jdc.test.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	@Pointcut("within(com.jdc.demo..*Service)")
	void serviceClasses() {}
	
	@Pointcut("execution(* hello(..))")
	void helloMethod() {}
	
	@Before(value = "serviceClasses() && helloMethod()")
	public void beforeInvocation(JoinPoint joinPoint) {
		System.out.println("Hello Before");
	}
}
