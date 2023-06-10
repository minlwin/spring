package com.jdc.demo.executions;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class ExecutionDemo {

	public static void main(String[] args) {
		
		var executor = Executors.newFixedThreadPool(5);
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("Start Runnable");
					Thread.sleep(1000);
					System.out.println("End Runnable");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		var runnableFuture = executor.submit(runnable);
		
		Callable<String> callable = new Callable<>() {

			@Override
			public String call() throws Exception {
				System.out.println("Start Callable");
				Thread.sleep(1000);
				System.out.println("End Callable");
				return "Call Result is OK";
			}
		};
		
		var callableFuture = executor.submit(callable);
		
		while(true) {
			if((runnableFuture.isCancelled() || runnableFuture.isDone()) 
					&& (callableFuture.isCancelled() || callableFuture.isDone())) {
				try {
					System.out.println("Callable result is %s".formatted(callableFuture.get()));
					executor.shutdown();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}	
			
			try {
				Thread.sleep(500);
				System.out.println("Check Result");
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
