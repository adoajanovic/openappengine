package com.openappengine.fms.print;


public interface PrintingServiceFacade {

	/**
	 * Prints a file to the default printer.
	 * @param file
	 */
	void printDocument(byte[] bytes);

}
