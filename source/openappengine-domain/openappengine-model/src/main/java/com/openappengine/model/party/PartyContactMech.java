package com.openappengine.model.party;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.openappengine.model.valueobject.ValueObject;

@Entity
@Table(name="PM_PARTY_CONTACT_MECH")
public class PartyContactMech implements ValueObject<PartyContactMech> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PM_CONTACT_MECH_ID", unique=true, nullable=false)
	private int contactMechId;

	@Column(name="PM_CONTACT_MECH_PURPOSE", nullable=false, length=50)
	private String contactMechPurpose;

	@Column(name="PM_CONTACT_MECH_TYPE", nullable=false, length=50)
	private String contactMechType;

	@Column(name="PM_INFO_STRING", nullable=false, length=100)
	private String infoString;

	//bi-directional many-to-one association to PmParty
    @ManyToOne
	@JoinColumn(name="PM_PARTY_ID", nullable=false)
	private Party party;

    public PartyContactMech() {
    }

	public int getContactMechId() {
		return contactMechId;
	}

	public void setContactMechId(int contactMechId) {
		this.contactMechId = contactMechId;
	}

	public String getContactMechPurpose() {
		return contactMechPurpose;
	}

	public void setContactMechPurpose(String contactMechPurpose) {
		this.contactMechPurpose = contactMechPurpose;
	}

	public String getContactMechType() {
		return contactMechType;
	}

	public void setContactMechType(String contactMechType) {
		this.contactMechType = contactMechType;
	}

	public String getInfoString() {
		return infoString;
	}

	public void setInfoString(String infoString) {
		this.infoString = infoString;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public boolean sameValueAs(PartyContactMech other) {
		return this.equals(other);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((contactMechPurpose == null) ? 0 : contactMechPurpose
						.hashCode());
		result = prime * result
				+ ((contactMechType == null) ? 0 : contactMechType.hashCode());
		result = prime * result
				+ ((infoString == null) ? 0 : infoString.hashCode());
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
		PartyContactMech other = (PartyContactMech) obj;
		if (contactMechPurpose == null) {
			if (other.contactMechPurpose != null)
				return false;
		} else if (!contactMechPurpose.equals(other.contactMechPurpose))
			return false;
		if (contactMechType == null) {
			if (other.contactMechType != null)
				return false;
		} else if (!contactMechType.equals(other.contactMechType))
			return false;
		if (infoString == null) {
			if (other.infoString != null)
				return false;
		} else if (!infoString.equals(other.infoString))
			return false;
		return true;
	}
}