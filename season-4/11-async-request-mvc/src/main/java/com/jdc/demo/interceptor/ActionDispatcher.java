package com.jdc.demo.interceptor;

public class ActionDispatcher {

	private Action action;
	private ActionInterceptor interceptor;
	
	public ActionDispatcher(Action action, ActionInterceptor interceptor) {
		super();
		this.action = action;
		this.interceptor = interceptor;
	}

	public void invokeAction() {
		
		try {
			// Other Concerns
			interceptor.preProcess(action);
			// Business Logic
			action.action();
			// Other Concerns
			interceptor.postProcess();
		} catch (Exception e) {
			// Other Concerns
			interceptor.onError(e);
		} finally {
			// Other Concerns
			interceptor.onFinish();
		}
		
	}
	
	public static void main(String[] args) {
		var dispath = new ActionDispatcher(() -> System.out.println("Working Other Action"), new CommonInterceptor());
		dispath.invokeAction();
	}
}
