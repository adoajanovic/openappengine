/**
 * 
 */
package com.ms.openapps.geolocation.iface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.ms.openapps.geolocation.GeoLocation;
import com.ms.openapps.util.UtilXml;

/**
 * @author hrishi
 * 
 */
public class GeoBytesInterface implements IGeoLocationInterface {

	private String queryParam = "IpAddress";

	private String geolocationServiceUrl;

	private String contentType = "xml.txt";
	
	/**
	 * Call geobytes.com and get the GeoLocation by parsing the returned
	 * contents.
	 * 
	 * @param ipAddress
	 * @return GeoLocation
	 */
	public GeoLocation getGeoLocation(String ipAddress) {
		GeoLocation geoLocation = new GeoLocation();
		try {
			URL link = new URL(getGeolocationServiceUrl()
					+ "/IpLocator.htm?GetLocation&template=" + contentType + "&"
					+ getQueryParam() + "=" + ipAddress);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					link.openStream()));
			String inputLine;
			StringBuffer xmlContent = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				xmlContent.append(inputLine);
			}
			in.close();
			Document doc = UtilXml.readXmlDocument(xmlContent.toString());
			if (doc.getElementsByTagName("country") != null) {
				Node countryNode = doc.getElementsByTagName("country").item(0);
				if (countryNode != null) {
					geoLocation.setCountry(countryNode.getTextContent());
				}
			}

			if (doc.getElementsByTagName("region") != null) {
				Node regionNode = doc.getElementsByTagName("region").item(0);
				if (regionNode != null) {
					geoLocation.setRegion(regionNode.getTextContent());
				}
			}

			if (doc.getElementsByTagName("city") != null) {
				Node cityNode = doc.getElementsByTagName("city").item(0);
				if (cityNode != null) {
					geoLocation.setCity(cityNode.getTextContent());
				}
			}

			if (doc.getElementsByTagName("latitude") != null) {
				Node latitudeNode = doc.getElementsByTagName("latitude")
						.item(0);
				if (latitudeNode != null) {
					geoLocation.setLatitude(latitudeNode.getTextContent());
				}
			}

			if (doc.getElementsByTagName("longitude") != null) {
				Node longitudeNode = doc.getElementsByTagName("longitude")
						.item(0);
				if (longitudeNode != null) {
					geoLocation.setLongitude(longitudeNode.getTextContent());
				}
			}

			if (doc.getElementsByTagName("timezone") != null) {
				Node timezoneNode = doc.getElementsByTagName("timezone")
						.item(0);
				if (timezoneNode != null) {
					geoLocation.setTimezone(timezoneNode.getTextContent());
				}
			}
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
		}
		return geoLocation;
	}

	/**
	 * @param queryParam
	 *            the queryParam to set
	 */
	public void setQueryParam(String queryParam) {
		this.queryParam = queryParam;
	}

	/**
	 * @return the queryParam
	 */
	public String getQueryParam() {
		return queryParam;
	}

	/**
	 * @param geolocationServiceUrl
	 *            the geolocationServiceUrl to set
	 */
	public void setGeolocationServiceUrl(String geolocationServiceUrl) {
		this.geolocationServiceUrl = geolocationServiceUrl;
	}

	/**
	 * @return the geolocationServiceUrl
	 */
	public String getGeolocationServiceUrl() {
		return geolocationServiceUrl;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

}
