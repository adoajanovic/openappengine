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
@Table(name="AB_TYPE")
public class AddressType implements ValueObject<AddressType> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AB_ADDRESS_TYPE_ID")
	private int addressRoleId;

	@Column(name="AB_TYPE_VALUE", nullable=false, length=100)
	private String type;
	
	@Column(name="AB_TYPE_FROM_DATE", nullable=false, length=100)
	private Date fromDate;
	
	@Column(name="AB_TYPE_TO_DATE", nullable=false, length=100)
	private Date toDate;
	
	public AddressType(){
	}
	
	public AddressType(String role, Date fromDate, Date toDate) {
		super();
		this.type = role;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String role) {
		this.type = role;
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
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		AddressType other = (AddressType) obj;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		return true;
	}

	public boolean sameValueAs(AddressType other) {
		return this.equals(other);
	}

	public int getAddressRoleId() {
		return addressRoleId;
	}

	public void setAddressRoleId(int addressRoleId) {
		this.addressRoleId = addressRoleId;
	}

}
