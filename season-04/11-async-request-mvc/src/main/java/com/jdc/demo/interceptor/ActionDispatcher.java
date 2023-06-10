package com.jdc.demo.interceptor;

public class ActionDispatcher {

	private Action action;
	private ActionInterceptor interceptor;
	
	public ActionDispatcher(Action action, ActionInterceptor ... interceptors) {
		super();
		this.action = action;
		this.interceptor = new ActionInterceptorChain(interceptors);
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
		
		var interceptor1 = new CommonInterceptor();
		var interceptor2 = new OtherInterceptor();
		Action businessLogic = () -> System.out.println("Working Other Action");
		
		var dispath = new ActionDispatcher(businessLogic, interceptor1, interceptor2);
		dispath.invokeAction();
	}
}
