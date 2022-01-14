package com.jdc.streams.listener;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;

public class DeferredResultLifecycle implements DeferredResultProcessingInterceptor{

	@Override
	public <T> void beforeConcurrentHandling(NativeWebRequest request, DeferredResult<T> deferredResult)
			throws Exception {
		System.out.println("""
				=======> Before DeferredResult Processing Start
				""");
		
	}
	
	@Override
	public <T> boolean handleTimeout(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
		System.out.println("""
				=======> Handle Timeout
				""");
		return true;
	}
	
	@Override
	public <T> boolean handleError(NativeWebRequest request, DeferredResult<T> deferredResult, Throwable t)
			throws Exception {
		System.out.println("""
				=======> Handle Exception in Interceptor
				""");
		return true;
	}
}
