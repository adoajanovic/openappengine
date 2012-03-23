/**
 * 
 */
package com.openappengine.oxm;

import java.io.InputStream;

import org.w3c.dom.Document;

/**
 * @author hrishi
 *
 */
public interface IOxmMapper {

	/**
	 * Marshal Object to XML
	 * 
	 * @param object
	 * @return Document
	 * @throws OxmMappingException
	 */
	public Document marshalObject(Object object) throws OxmMappingException;

	/**
	 * Unmarshal XML to Object
	 * 
	 * @param document
	 * @return Object
	 * @throws OxmMappingException
	 */
	public Object unmarshal(Document document) throws OxmMappingException;

	public Object unmarshal(InputStream fis) throws OxmMappingException;

}
