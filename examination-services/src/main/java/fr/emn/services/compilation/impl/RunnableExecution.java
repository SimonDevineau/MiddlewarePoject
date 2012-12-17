package fr.emn.services.compilation.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunnableExecution implements Runnable {

	ExecuteResult result;
	Method method;
	Object[] args;

	public RunnableExecution(ExecuteResult result, Method method, Object[] args) {
		super();
		this.result = result;
		this.method = method;
		this.args = args;
	}

	@Override
	public void run() {
		Object executionResult = null;
		try {
			executionResult = method.invoke(null, args);
			this.result.setSucceeded(true);
			this.result.setResult(executionResult.toString());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			this.result.setError(e.getCause().toString());
			this.result.setSucceeded(false);
			e.printStackTrace();
		}
	}

}
