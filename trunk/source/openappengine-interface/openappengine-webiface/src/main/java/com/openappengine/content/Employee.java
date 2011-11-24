package com.openappengine.content;

import java.awt.event.ActionEvent;
import java.io.Serializable;


public class Employee implements Serializable {
	
	private String firstName;
	private String lastName;
	private String address;
	private String emailAddress;
        private Long id;
        private boolean rendered= true;
        private String district;
        private String city;
        private String phone;

	public Employee(Long id, String district, String city, String first,
                String last,  String phone){
            this.id=id;
            this.district=district;
            this.city=city;
            this.firstName=first;
            this.lastName=last;
            this.phone=phone;
        }

	public Employee(Long id, String firstName, String lastName, String address,
			        String emailAddress) {
                this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAddress = emailAddress;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void showTab(ActionEvent event){
		this.setRendered(true);
		System.out.println("showing Tab as rendered="+rendered);
	}
	public void hideTab(ActionEvent event){
		this.setRendered(false);
		System.out.println("showing Tab as NOT rendered="+rendered);
	}

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phoneNumber) {
        this.phone = phoneNumber;
    }
   
}
