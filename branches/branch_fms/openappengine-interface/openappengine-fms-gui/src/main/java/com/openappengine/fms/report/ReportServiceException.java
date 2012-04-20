/**
 * 
 */
package com.openappengine.fms.report;

/**
 * @author hrishi
 *
 */
public class ReportServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ReportServiceException() {
		super();
	}

	public ReportServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReportServiceException(String message) {
		super(message);
	}

	public ReportServiceException(Throwable cause) {
		super(cause);
	}

}
