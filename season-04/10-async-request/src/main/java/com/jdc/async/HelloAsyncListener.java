package com.jdc.async;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class HelloAsyncListener implements AsyncListener{

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("Complete Async Process");
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		System.out.println("Timeout Async Process");
		event.getAsyncContext().complete();
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		System.out.println("Error Async Process");
		event.getAsyncContext().dispatch("error.jsp");
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("Start Async Process");
	}

}
