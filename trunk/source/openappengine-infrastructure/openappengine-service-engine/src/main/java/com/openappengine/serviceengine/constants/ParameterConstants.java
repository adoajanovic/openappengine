/**
 *  Parameter Constants : Class used for Parameter passing to and from the Services.
 */
package com.openappengine.serviceengine.constants;

import java.io.Serializable;

/**
 * @author hrishi
 * 
 */
public class ParameterConstants implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Parameter names should be in the form of
	 * <SERVICE_NAME>_[IN/OUT/INOUT]_<PARAM_NAME>
	 */

	public static final String AUTHORIZATION_SERVICE_INOUT_USERNAME = "username";

	public static final String AUTHORIZATION_SERVICE_INOUT_PASSWORD = "password";

	public static final String AUTHORIZATION_SERVICE_OUT_APPUSER = "grantedAuthorities";

	public static final String GEOLOCATION_SERVICE_IN_IPADDRESS = "GeoLocationService.ipAddress";

	public static final String GEOLOCATION_SERVICE_OUT_GEOLOCATION = "GeoLocationService.geolocation";

	public static final String SERVICE_RESPONSE = "ServiceResponse";

	public static final String SERVICE_FAILED = "FAIL";

	public static final String SERVICE_SUCCESS = "SUCCESS";

	public static final String SERVICE_ERROR_MESSAGE = "ServiceErrorMessage";

	public static final String SERVICE_PHASE = "CURRENT_PHASE";

}
