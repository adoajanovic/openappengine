/**
 * 
 */
package com.openappengine.model.addressbook;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.openappengine.model.valueobject.ValueObject;

/**
 * @author hrishi
 *
 */
@Entity
@Table(name="AB_ROLE")
public class AddressRole implements ValueObject<AddressRole> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AB_ADDRESS_ROLE_ID")
	private int addressRoleId;

	@Column(name="AB_ROLE_VALUE", nullable=false, length=100)
	private String role;
	
	@Column(name="AB_ROLE_FROM_DATE", nullable=false, length=100)
	private Date fromDate;
	
	@Column(name="AB_ROLE_TO_DATE", nullable=false, length=100)
	private Date toDate;
	
	public AddressRole(){
	}
	
	public AddressRole(String role, Date fromDate, Date toDate) {
		super();
		this.role = role;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressRole other = (AddressRole) obj;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		return true;
	}

	public boolean sameValueAs(AddressRole other) {
		return this.equals(other);
	}

	public int getAddressRoleId() {
		return addressRoleId;
	}

	public void setAddressRoleId(int addressRoleId) {
		this.addressRoleId = addressRoleId;
	}

}
