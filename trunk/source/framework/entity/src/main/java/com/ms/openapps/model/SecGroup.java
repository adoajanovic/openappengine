package com.ms.openapps.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sec_group database table.
 * 
 */
@Entity
@Table(name="sec_group")
public class SecGroup extends com.ms.openapps.entity.GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GROUP_ID")
	private int groupId;

	@Column(name="GROUP_NAME")
	private String groupName;

	//bi-directional many-to-many association to SecAppUser
	@ManyToMany(mappedBy="secGroups")
	private List<SecAppUser> secAppUsers;

    public SecGroup() {
    }

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<SecAppUser> getSecAppUsers() {
		return this.secAppUsers;
	}

	public void setSecAppUsers(List<SecAppUser> secAppUsers) {
		this.secAppUsers = secAppUsers;
	}
	
}