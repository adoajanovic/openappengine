/**
 * 
 */
package com.openappengine.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author hrishi
 *
 */
public class UtilProperties {
	
	private static UtilLogger logger = new UtilLogger(UtilProperties.class);
	
	/** Returns the value of the specified property name from the specified resource/properties file
     * @param resource The name of the resource - can be a file, class, or URL
     * @param name The name of the property in the properties file
     * @return The value of the property in the properties file
     */
    public static String getPropertyValue(InputStream resource, String name) {
        Properties properties = getProperties(resource);
        if (properties == null) {
            return "";
        }

        String value = null;
        try {
            value = properties.getProperty(name);
        } catch (Exception e) {
            logger.logError( "Error loading the property " + name + " in resource " + resource,e);
        }
        return value == null ? "" : value.trim();
    }
    
    /**
     * @param resource
     * @param propertyName
     * @return Boolean PropertyValue
     */
    public static Boolean getBooleanValue(InputStream resource,String propertyName) {
    	String propertyValue = getPropertyValue(resource, propertyName);
    	return Boolean.parseBoolean(propertyValue);
    }
    
    public static Properties getProperties(InputStream resource)  {
    	
    	if (resource == null) return null;
    	
    	Properties properties = new Properties();
    	try {
			properties.load(resource);
		} catch (IOException e) {
			//TODO
			return null;
		}
    	return properties;
    }
}