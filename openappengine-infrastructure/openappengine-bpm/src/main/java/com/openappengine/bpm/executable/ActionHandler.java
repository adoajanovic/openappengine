/**
 *  Represents the ActionHandler to be performed during the Runtime process.
 *  When the State is reached. 
 * 
 */
package com.openappengine.bpm.executable;

/**
 * @author hrishi
 *
 */
public abstract class ActionHandler implements Executable {

	public abstract void execute(ExecutionContext context);
	
}
