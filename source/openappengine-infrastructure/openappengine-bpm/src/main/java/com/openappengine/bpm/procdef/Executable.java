/**
 * 
 */
package com.openappengine.bpm.procdef;

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
