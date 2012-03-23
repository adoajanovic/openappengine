/**
 * 
 */
package com.openappengine.model.party;

import java.util.Date;

import org.apache.commons.lang.Validate;

import com.openappengine.model.specification.AbstractSpecification;
import com.openappengine.model.valueobject.ValueObject;

/**
 * @author hrishi
 * 
 */
public class PersonSpecification extends AbstractSpecification<Person> implements ValueObject<PersonSpecification> {

	private String salutation;

	private String firstName;

	private String middleName;

	private String lastName;

	private String suffix;

	private String nickname;

	private boolean gender;

	private Date birthDate;

	private Date deceasedDate;

	private String maritalStatus;

	private String socialSecurityNumber;

	private String passportNumber;

	private Date passportExpireDate;

	private String comments;

	public PersonSpecification(String firstName,String lastName) {
		super();
		Validate.notNull(firstName, "First Name : Cannot be null");
		Validate.notNull(lastName, "Last Name : Cannot be null");

		this.firstName = firstName;
		this.lastName = lastName;
	}

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


	public String getSuffix() {
		return suffix;
	}


	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public boolean isGender() {
		return gender;
	}


	public void setGender(boolean gender) {
		this.gender = gender;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public Date getDeceasedDate() {
		return deceasedDate;
	}


	public void setDeceasedDate(Date deceasedDate) {
		this.deceasedDate = deceasedDate;
	}


	public String getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}


	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}


	public String getPassportNumber() {
		return passportNumber;
	}


	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}


	public Date getPassportExpireDate() {
		return passportExpireDate;
	}


	public void setPassportExpireDate(Date passportExpireDate) {
		this.passportExpireDate = passportExpireDate;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
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
		PersonSpecification other = (PersonSpecification) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;

		return true;
	}

	@Override
	public boolean sameValueAs(PersonSpecification other) {
		return this.equals(other);
	}

	@Override
	public boolean isSatisfiedBy(Person t) {
		if(t == null) {
			return false;
		}
		
		if (t.getFirstName() == null || t.getLastName() == null
				|| t.getSalutation() == null) {
			return false;
		}
		
		PersonSpecification specification = new PersonSpecification(t.getFirstName(), t.getLastName());
		return this.sameValueAs(specification);
	}

}
