/**
 * 
 */
package com.ms.openapps.security.registry;

import java.util.Date;

import com.ms.openapps.util.DateTimeUtil;

/**
 * @author hrishi
 *
 */
public class LoggedInUser {
	
	private String username;
	
	private String password;
	
	private  boolean isAccountNonExpired;
	
	private boolean isAccountNonLocked;
	
	private  boolean 	isCredentialsNonExpired;
	
	private  boolean 	isEnabled;
	
	private Date dtLoggedIn = DateTimeUtil.nowDate();

	public LoggedInUser() {
	}
	
	public LoggedInUser(String username, String password,
			boolean isAccountNonExpired, boolean isAccountNonLocked,
			boolean isCredentialsNonExpired, boolean isEnabled, Date dtLoggedIn) {
		super();
		this.username = username;
		this.password = password;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
		this.dtLoggedIn = dtLoggedIn;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isAccountNonExpired
	 */
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	/**
	 * @param isAccountNonExpired the isAccountNonExpired to set
	 */
	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	/**
	 * @return the isAccountNonLocked
	 */
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	/**
	 * @param isAccountNonLocked the isAccountNonLocked to set
	 */
	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	/**
	 * @return the isCredentialsNonExpired
	 */
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	/**
	 * @param isCredentialsNonExpired the isCredentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	/**
	 * @return the isEnabled
	 */
	public boolean isEnabled() {
		return isEnabled;
	}

	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * @param dtLoggedIn the dtLoggedIn to set
	 */
	public void setDtLoggedIn(Date dtLoggedIn) {
		this.dtLoggedIn = dtLoggedIn;
	}

	/**
	 * @return the dtLoggedIn
	 */
	public Date getDtLoggedIn() {
		return dtLoggedIn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoggedInUser [username=" + username + ", password=" + password
				+ ", isAccountNonExpired=" + isAccountNonExpired
				+ ", isAccountNonLocked=" + isAccountNonLocked
				+ ", isCredentialsNonExpired=" + isCredentialsNonExpired
				+ ", isEnabled=" + isEnabled + ", dtLoggedIn=" + dtLoggedIn
				+ "]";
	}

}
