/**
 * 
 */
package com.openappengine.forms;

import java.io.Serializable;

import com.openappengine.web.annotations.Required;

/**
 * @author hrishikesh.joshi
 *
 */
public class LoginFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Required
	private String username;
	
	@Required
	private String password;
	
	private Long age;
	
	private String mobileNo;
	
	public String save() {
		System.out.println("asasas");
		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}
