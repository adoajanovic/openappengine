/**
 * 
 */
package com.openappengine.web.apps.login;

import com.openappengine.form.UIForm;
import com.openappengine.web.annotations.ADAutocomplete;
import com.openappengine.web.annotations.Required;

/**
 * @author hrishi
 * 
 */
public class LoginFormBean extends UIForm {

    private static final long serialVersionUID = 1L;

    @Required
    private String username;

    @Required
    private String password;

    @ADAutocomplete(type = "currency")
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

    @Override
    public void preRenderAction() {
	this.preferredCurrency = "INR";
    }

}
