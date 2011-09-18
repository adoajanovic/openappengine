/**
 * 
 */
package com.openappengine.servicedef.codes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;

/**
 * @author hrishi
 *
 */
public class ApplicationCodeFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static Map<String, Document> applicationCodeCache;
	
	static {
		applicationCodeCache = new HashMap<String, Document>();
	}
	
	public static boolean containsCode(String codeType) {
		return applicationCodeCache.containsKey(codeType);
	}

	public static Document getCode(String codeType) {
		return applicationCodeCache.get(codeType);
	}
	
	public static void addCode(String codeType,Document code) {
		applicationCodeCache.put(codeType, code);
	}

}
