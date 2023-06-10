package com.jdc.demo.interceptor;

public class CommonInterceptor implements ActionInterceptor{

	@Override
	public void preProcess(Action action) {
		System.out.println("Pre Processing in Common Interceptor");
	}

}
