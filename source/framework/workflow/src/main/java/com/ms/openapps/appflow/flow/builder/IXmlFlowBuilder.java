/**
 * 
 */
package com.ms.openapps.appflow.flow.builder;

import java.io.IOException;

import com.ms.openapps.appflow.flow.Flow;

/**
 * @author hrishi
 *
 */
public interface IXmlFlowBuilder {
	
	/**
	 *  Construct the App Flow from the XML Document
	 * @param flowDocument
	 * @return
	 * @throws IOException 
	 */
	public Flow createClasspathXmlFlow(String xmlWorkFlowPath) throws IOException;
	
}