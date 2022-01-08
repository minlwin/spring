package com.jdc.async.controller.interceptors;

import java.util.concurrent.Callable;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

import com.jdc.async.controller.task.CallabeTask;

public class CustomCallableInterceptor implements CallableProcessingInterceptor{
	
	@Override
	public <T> void beforeConcurrentHandling(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("=================================");
		System.out.println("=====beforeConcurrentHandling====");
		System.out.println("=================================");
		
		if(task instanceof CallabeTask custom) {
			custom.add("Message from Before Concrrent Handling.");
		}
	}

	@Override
	public <T> void preProcess(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("=================================");
		System.out.println("=====preProcess====");
		System.out.println("=================================");
		
		if(task instanceof CallabeTask custom) {
			custom.add("Message from Pre Processing.");
		}
	}
	
	@Override
	public <T> void postProcess(NativeWebRequest request, Callable<T> task, Object concurrentResult) throws Exception {
		System.out.println("=================================");
		System.out.println("=====postProcess====");
		System.out.println("=================================");
		if(task instanceof CallabeTask custom) {
			custom.add("Message from Post Processing.");
		}
	}
	
	@Override
	public <T> Object handleError(NativeWebRequest request, Callable<T> task, Throwable t) throws Exception {
		System.out.println("=================================");
		System.out.println("=====handleError====");
		System.out.println("=================================");
		return RESULT_NONE;
	}

	@Override
	public <T> void afterCompletion(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("=================================");
		System.out.println("=====afterCompletion====");
		System.out.println("=================================");
		if(task instanceof CallabeTask custom) {
			custom.add("Message from After Completion.");
		}
	}
	
	@Override
	public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("=================================");
		System.out.println("=====handleTimeout====");
		System.out.println("=================================");
		return RESULT_NONE;
	}
	
}
