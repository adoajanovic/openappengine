/**
 * 
 */
package com.openappengine.facade.party.dto;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class AddressCommand implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String toName;
	
	private String attnName;
	
	private String address1;
	
	private String address2;
	
	private String directions;
	
	private String city;
	
	private String postalCode;
	
	private String postalCodeExt;
	
	private String country;
	
	private String stateProvince;

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getAttnName() {
		return attnName;
	}

	public void setAttnName(String attnName) {
		this.attnName = attnName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPostalCodeExt() {
		return postalCodeExt;
	}

	public void setPostalCodeExt(String postalCodeExt) {
		this.postalCodeExt = postalCodeExt;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	
}
