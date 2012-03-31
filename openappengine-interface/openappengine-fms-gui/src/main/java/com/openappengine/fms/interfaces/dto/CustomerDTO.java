/**
 * 
 */
package com.openappengine.fms.interfaces.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author hrishi
 *
 */
public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = 6814597492747419734L;
	
	private int partyId;
	
	private String status;
	
	private String salutation;

	private String firstName;

	private String middleName;

	private String lastName;

	private String gender;

	private Date birthDate;

	private String comments;
	
	private AddressDTO addressDTO;
	
	private List<ContactMechDTO> contactMechDTOs;

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public List<ContactMechDTO> getContactMechDTOs() {
		return contactMechDTOs;
	}

	public void setContactMechDTOs(List<ContactMechDTO> contactMechDTOs) {
		this.contactMechDTOs = contactMechDTOs;
	}

	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
