package com.jdc.async.controller.interceptors;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;

import com.jdc.async.controller.task.DeferredTask;

public class CustomDeferredInterceptor implements DeferredResultProcessingInterceptor{

	@Override
	public <T> void beforeConcurrentHandling(NativeWebRequest request, DeferredResult<T> deferredResult)
			throws Exception {
		
		if(deferredResult instanceof DeferredTask task) {
			var error = request.getParameter("error");
			task.setError(error);
		}
		
		System.out.println("""
				========> Before Concurrent Start
				""");
	}
	
	@Override
	public <T> void preProcess(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
		System.out.println("""
				========> Pre Process
				""");
	}
	
	@Override
	public <T> void postProcess(NativeWebRequest request, DeferredResult<T> deferredResult, Object concurrentResult)
			throws Exception {
		System.out.println("""
				========> Post Process
				""");
	}
	
	@Override
	public <T> void afterCompletion(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
		System.out.println("""
				========> After Completion
				""");
	}
	
	@Override
	public <T> boolean handleTimeout(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
		System.out.println("""
				========> Timeout Handler : CustomDeferredInterceptor
				""");
		return true;
	}
	
	@Override
	public <T> boolean handleError(NativeWebRequest request, DeferredResult<T> deferredResult, Throwable t)
			throws Exception {
		System.out.println("""
				========> Exception Handler : CustomDeferredInterceptor
				""");
		return true;
	}
}
