package com.openappengine.fms.print;

import java.io.File;

public interface PrintingServiceFacade {

	/**
	 * Prints a file to the default printer.
	 * @param file
	 */
	void printDocument(File file);

}
