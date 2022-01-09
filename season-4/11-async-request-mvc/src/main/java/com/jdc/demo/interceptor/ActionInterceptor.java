package com.jdc.demo.interceptor;

public interface ActionInterceptor {
	
	default void preProcess(Action action) {}
	
	default void postProcess() {}
	
	default void onFinish() {}
	
	default void onError(Exception e) {}

}
