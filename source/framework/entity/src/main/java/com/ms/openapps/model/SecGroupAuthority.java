package com.ms.openapps.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sec_group_authority database table.
 * 
 */
@Entity
@Table(name="sec_group_authority")
public class SecGroupAuthority extends com.ms.openapps.entity.GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AUTHORITY")
	private String authority;

	@Column(name="GROUP_ID")
	private String groupId;

	//bi-directional one-to-one association to SecAuthority
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AUTHORITY")
	private SecAuthority secAuthority;

    public SecGroupAuthority() {
    }

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public SecAuthority getSecAuthority() {
		return this.secAuthority;
	}

	public void setSecAuthority(SecAuthority secAuthority) {
		this.secAuthority = secAuthority;
	}
	
}