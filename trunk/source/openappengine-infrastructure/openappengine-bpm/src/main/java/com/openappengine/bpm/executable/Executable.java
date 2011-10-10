/**
 * 
 */
package com.openappengine.bpm.executable;

/**
 * @author hrishi
 *
 */
public interface Executable {
	
	/**
	 * Execute the executable context.
	 * @param context
	 */
	public void execute(ExecutionContext context);

}
