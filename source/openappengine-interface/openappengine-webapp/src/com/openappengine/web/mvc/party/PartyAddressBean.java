/**
 * 
 */
package com.openappengine.web.mvc.party;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hrishi
 *
 */
public class PartyAddressBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int addressBookId;
	
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
	
	private Set<String> roles = new HashSet<String>();
	
	@Override
	public String toString() {
		return address1 + "," + address2 + "," + city + ", " + postalCode
				+ "," + country + "," + stateProvince + "";
	}

	public int getAddressBookId() {
		return addressBookId;
	}

	public void setAddressBookId(int addressBookId) {
		this.addressBookId = addressBookId;
	}

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

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
