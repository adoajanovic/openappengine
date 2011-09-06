/**
 * 
 */
package com.ms.openapps.util;

import java.io.Serializable;

import javolution.util.FastMap;

import com.ms.openapps.util.factory.GenericFactory;

/**
 * @author hrishi
 *
 */
public class UtilFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @return GenericFactory
	 */
	public static FastMap newGenericFactory() {
		FastMap newInstance = GenericFactory.newInstance();
		return newInstance;
	}

}
