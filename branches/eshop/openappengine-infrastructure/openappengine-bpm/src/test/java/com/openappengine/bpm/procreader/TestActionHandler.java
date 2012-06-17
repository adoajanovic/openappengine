/**
 * 
 */
package com.openappengine.bpm.procreader;

import com.openappengine.bpm.executable.ActionHandler;
import com.openappengine.bpm.executable.ExecutionContext;

/**
 * @author hrishi
 *
 */
public class TestActionHandler extends ActionHandler {

	/* (non-Javadoc)
	 * @see com.openappengine.bpm.executable.ActionHandler#execute(com.openappengine.bpm.executable.ExecutionContext)
	 */
	@Override
	public void execute(ExecutionContext context) {
		System.out.println("Hello World !");
	}

}
