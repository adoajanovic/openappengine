/**
 * 
 */
package com.openappengine.gui.engine.core.executor.annotations;

/**
 * @author hrishi
 * since Feb 7, 2012
 */
public enum Mode {

	XML("xml"),
	POJO("pojo"),
	ALL("all");
	
	String mode;
	
	Mode(String mode) {
		this.mode = mode;
	};
	
}
