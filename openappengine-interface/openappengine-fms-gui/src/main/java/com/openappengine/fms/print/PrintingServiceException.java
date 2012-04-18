/**
 * 
 */
package com.openappengine.fms.print;

/**
 * @author hrishi
 *
 */
public class PrintingServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PrintingServiceException() {
		super();
	}

	public PrintingServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PrintingServiceException(String message) {
		super(message);
	}

	public PrintingServiceException(Throwable cause) {
		super(cause);
	}

}
