/**
 * 
 */
package com.openappengine.gui.engine.context.factory.xml;

import org.springframework.beans.factory.parsing.ProblemReporter;
import org.springframework.beans.factory.parsing.ReaderContext;
import org.springframework.beans.factory.parsing.ReaderEventListener;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.core.io.Resource;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class ScreenReaderContext extends ReaderContext {

	/**
	 * @param resource
	 * @param problemReporter
	 * @param eventListener
	 * @param sourceExtractor
	 */
	public ScreenReaderContext(Resource resource, ProblemReporter problemReporter, ReaderEventListener eventListener,
			SourceExtractor sourceExtractor) {
		super(resource, problemReporter, eventListener, sourceExtractor);
	}

}
