/**
 * 
 */
package com.openappengine.utility;

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
