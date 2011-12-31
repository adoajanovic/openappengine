/**
 * 
 */
package com.openappengine.facade.context.factory.support.parser;

/**
 * @author hrishi
 * since Dec 31, 2011
 */
public class XmlDefinitionParserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public XmlDefinitionParserException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public XmlDefinitionParserException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public XmlDefinitionParserException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public XmlDefinitionParserException(String message, Throwable cause) {
		super(message, cause);
	}

}
