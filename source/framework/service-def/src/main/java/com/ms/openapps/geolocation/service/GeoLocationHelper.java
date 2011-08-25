/**
 * 
 */
package com.ms.openapps.geolocation.service;

import com.ms.openapps.geolocation.GeoLocation;
import com.ms.openapps.geolocation.iface.IGeoLocationInterface;

/**
 * @author hrishi
 * 
 */
public class GeoLocationHelper {
	
	private IGeoLocationInterface geoLocationInterface;
	
	public GeoLocation getGeoLocationFromIP(String ipAddress) {
		if (ipAddress == null) {
			return null;
		}
		return geoLocationInterface.getGeoLocation(ipAddress);
	}

	/**
	 * @param geoLocationInterface the geoLocationInterface to set
	 */
	public void setGeoLocationInterface(IGeoLocationInterface geoLocationInterface) {
		this.geoLocationInterface = geoLocationInterface;
	}

	/**
	 * @return the geoLocationInterface
	 */
	public IGeoLocationInterface getGeoLocationInterface() {
		return geoLocationInterface;
	}

}
