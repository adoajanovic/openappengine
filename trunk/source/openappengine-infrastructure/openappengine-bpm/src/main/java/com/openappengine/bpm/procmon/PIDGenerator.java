/**
 * 
 */
package com.openappengine.bpm.procmon;

import java.util.UUID;

/**
 * @author hrishi
 *
 */
public class PIDGenerator {
	
	/**
	 * @return
	 */
	public static String newProcessId() {
		return UUID.randomUUID().toString();
	}

}
