package com.jdc.demo.interceptor;

public class OtherInterceptor implements ActionInterceptor{

	@Override
	public void preProcess(Action action) {
		System.out.println("Pre Process from other interceptor");
	}
	
	@Override
	public void postProcess() {
		System.out.println("Post Process from other interceptor");
	}
}
