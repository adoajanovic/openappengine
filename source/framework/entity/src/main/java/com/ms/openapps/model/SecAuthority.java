package com.ms.openapps.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sec_authority database table.
 * 
 */
@Entity
@Table(name="sec_authority")
public class SecAuthority extends com.ms.openapps.entity.GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AUTHORITY")
	private String authority;

	//bi-directional many-to-one association to SecAppUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERNAME")
	private SecAppUser secAppUser;

	//bi-directional one-to-one association to SecGroupAuthority
	@OneToOne(mappedBy="secAuthority", fetch=FetchType.LAZY)
	private SecGroupAuthority secGroupAuthority;

    public SecAuthority() {
    }

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public SecAppUser getSecAppUser() {
		return this.secAppUser;
	}

	public void setSecAppUser(SecAppUser secAppUser) {
		this.secAppUser = secAppUser;
	}
	
	public SecGroupAuthority getSecGroupAuthority() {
		return this.secGroupAuthority;
	}

	public void setSecGroupAuthority(SecGroupAuthority secGroupAuthority) {
		this.secGroupAuthority = secGroupAuthority;
	}
	
}