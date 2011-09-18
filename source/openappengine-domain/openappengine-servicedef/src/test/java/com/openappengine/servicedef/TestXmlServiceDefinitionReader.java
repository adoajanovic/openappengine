/**
 * 
 */
package com.openappengine.servicedef;

import org.junit.Test;

import com.openappengine.serviceengine.reader.XmlServiceDefinitionReader;

/**
 * @author hrishi
 *
 */
public class TestXmlServiceDefinitionReader {

	@Test
	public void testXmlServiceDefinitionReader() {
		XmlServiceDefinitionReader xmlServiceDefinitionReader = new XmlServiceDefinitionReader("ServiceDefinition.xml");
		xmlServiceDefinitionReader.loadModelServices();
	}

}
