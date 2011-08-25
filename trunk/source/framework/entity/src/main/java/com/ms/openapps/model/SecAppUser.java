package com.ms.openapps.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sec_app_user database table.
 * 
 */
@Entity
@Table(name="sec_app_user")
public class SecAppUser extends com.ms.openapps.entity.GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USERNAME")
	private String username;

	@Column(name="ENABLED")
	private boolean enabled = true;

	@Column(name="PASSWORD")
	private String password;

	//bi-directional many-to-one association to SecAuthority
	@OneToMany(mappedBy="secAppUser")
	private List<SecAuthority> secAuthorities;

	//bi-directional many-to-many association to SecGroup
    @ManyToMany
	@JoinTable(
		name="sec_group_user"
		, joinColumns={
			@JoinColumn(name="USERNAME")
			}
		, inverseJoinColumns={
			@JoinColumn(name="GROUP_ID")
			}
		)
	private List<SecGroup> secGroups;

    public SecAppUser() {
    }

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SecAuthority> getSecAuthorities() {
		return this.secAuthorities;
	}

	public void setSecAuthorities(List<SecAuthority> secAuthorities) {
		this.secAuthorities = secAuthorities;
	}
	
	public List<SecGroup> getSecGroups() {
		return this.secGroups;
	}

	public void setSecGroups(List<SecGroup> secGroups) {
		this.secGroups = secGroups;
	}
	
}