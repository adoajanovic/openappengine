/**
 * 
 */
package com.ms.openapps.geolocation.service;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ms.openapps.geolocation.GeoLocation;
import com.ms.openapps.service.ServiceUtil;
import com.ms.openapps.service.constants.ParameterConstants;
import com.ms.openapps.service.context.DispatchContext;
import com.ms.openapps.util.UtilGenerics;

/**
 * @author hrishi
 *
 */
public class GeoLocationService {

	private static GeoLocationHelper geolocationHelper;
	
	static {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("GeoLocationContext.xml");
		geolocationHelper = (GeoLocationHelper) applicationContext.getBean("geolocationHelper");
	}
	
	/**
	 *  Get GeoLocation from IPAddress
	 * @param dispatchContext
	 * @param params
	 * @return GeoLocation
	 */
	public Map<String,Object> getGeoLocationFromIP(DispatchContext dispatchContext,Map<String,Object> params) {
		Map<String, Object> result = UtilGenerics.getFastMap();
		String ipAddress = (String) params.get(ParameterConstants.GEOLOCATION_SERVICE_IN_IPADDRESS);
		GeoLocation geoLocation = geolocationHelper.getGeoLocationFromIP(ipAddress );
		result.put(ParameterConstants.GEOLOCATION_SERVICE_OUT_GEOLOCATION, geoLocation);
		return ServiceUtil.returnSuccess(result);
	}
	
}
