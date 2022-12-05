package com.jdc.demo.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CommonPointCuts {

	@Pointcut("execution(* search*(..))")
	public void searchMethods() {}
	
	@Pointcut("within(com..member.dao.*)")
	public void memberDaoClasses() {}
	
	@Pointcut("@within(com.jdc.demo.utils.NeedToLogBefore)")
	public void needToLogBeforeClasses() {}

}
