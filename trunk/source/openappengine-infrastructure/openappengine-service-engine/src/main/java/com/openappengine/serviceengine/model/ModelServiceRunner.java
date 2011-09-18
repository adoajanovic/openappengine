/**
 * 
 */
package com.openappengine.serviceengine.model;


/**
 * @author hrishi
 * 
 */
public class ModelServiceRunner {

	private Class<?> runnerClass;

	/**
	 * @param runnerClass
	 * @param runnerMethod
	 */
	public ModelServiceRunner(Class<?> runnerClass) {
		super();
		this.runnerClass = runnerClass;
	}

	public Class<?> getRunnerClass() {
		return runnerClass;
	}

	public void setRunnerClass(Class<?> runnerClass) {
		this.runnerClass = runnerClass;
	}
}
