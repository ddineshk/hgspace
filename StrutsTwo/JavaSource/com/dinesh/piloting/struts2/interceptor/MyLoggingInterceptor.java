package com.dinesh.piloting.struts2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyLoggingInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3035830874480303207L;

	@Override
	public void destroy() {
		System.out.println("Destroying!");

	}

	@Override
	public void init() {
		System.out.println("Initializing!");

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String className = invocation.getAction().getClass().getName();
		long startTime = System.currentTimeMillis();
		System.out.println("Before calling action: " + className);
		
		String result = invocation.invoke();
		long endTime = System.currentTimeMillis();
		
		System.out.println("After calling action: " + className
                + " Time taken: " + (endTime - startTime) + " ms");
		return result;
	}

}
