/**
 * 
 */
package com.ms.openapps.oxm.beans;

import java.io.Serializable;

/**
 * @author h.shrikant.joshi
 *
 */
public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private int proficiency;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProficiency() {
		return proficiency;
	}

	public void setProficiency(int proficiency) {
		this.proficiency = proficiency;
	}

}
