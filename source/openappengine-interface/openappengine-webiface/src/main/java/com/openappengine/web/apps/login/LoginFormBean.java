/**
 * 
 */
package com.openappengine.web.apps.login;

import java.io.Serializable;

import com.openappengine.web.annotations.ADDataList;
import com.openappengine.web.annotations.Required;

/**
 * @author hrishi
 *
 */
public class LoginFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String password;
	
	@ADDataList(type="currency")
	@Required
	private String preferredCurrency;

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
	
	public String login() {
		return null;
	}

	public String getPreferredCurrency() {
		return preferredCurrency;
	}

	public void setPreferredCurrency(String preferredCurrency) {
		this.preferredCurrency = preferredCurrency;
	}

}
