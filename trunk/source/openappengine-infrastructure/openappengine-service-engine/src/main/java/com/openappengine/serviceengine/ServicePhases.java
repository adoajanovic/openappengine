/**
 * 	Service Phases Constants
 */
package com.openappengine.serviceengine;

import java.io.Serializable;

/**
 * @author hrishi
 * 
 */
public class ServicePhases implements Serializable {

	private static final long serialVersionUID = 8174608913833209929L;
	
	public static final int STARTED = 1;

	public static final int PRE_PROCESSING_PHASE_STARTED = 5;
	
	public static final int PRE_PROCESSING_PHASE_COMPLETE = 10;

	public static final int PROCESSING_PHASE_STARTED = 15;
	
	public static final int PROCESSING_PHASE_COMPLETE = 20;

	public static final int POST_PROCESSING_PHASE_STARTED = 25;
	
	public static final int POST_PROCESSING_PHASE_COMPLETE = 30;
	
	public static final int COMPLETE = 100;
	
	public static final int ERROR = -999;

}
