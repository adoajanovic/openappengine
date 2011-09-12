/**
 * 
 */
package com.ms.openapps.util;

import java.util.UUID;

/**
 * @author hrishi
 *
 */
public class UUIDKeyGenerator{
	
	
	public static String getDefaultUUID()
	{
		return UUID.randomUUID().toString();
	}

}
