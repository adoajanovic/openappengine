/**
 * 
 */
package com.ms.openapps.geolocation.iface;

import com.ms.openapps.geolocation.GeoLocation;

/**
 * @author hrishi
 *
 */
public interface IGeoLocationInterface {

	public GeoLocation getGeoLocation(String ipAddress);
	
}
