package com.jdc.demo.interceptor;

import java.util.Arrays;
import java.util.List;

public class ActionInterceptorChain implements ActionInterceptor{
	
	private List<ActionInterceptor> chian;
	
	public ActionInterceptorChain(ActionInterceptor[] interceptors) {
		chian = Arrays.stream(interceptors).toList();
	}

	@Override
	public void preProcess(Action action) {
		for(var interceptor : chian) {
			interceptor.preProcess(action);
		}
	}
	
	@Override
	public void postProcess() {
		for(var interceptor : chian) {
			interceptor.postProcess();
		}
	}
	
	@Override
	public void onError(Exception e) {
		for(var interceptor : chian) {
			interceptor.onError(e);
		}
	}
	
	@Override
	public void onFinish() {
		for(var interceptor : chian) {
			interceptor.onFinish();;
		}
	}
}
