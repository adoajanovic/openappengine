/**
 * 
 */
package com.ms.openapps.oxm.beans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author h.shrikant.joshi
 *
 */
public class CreateEmployeeRequestPayload extends PayloadData {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private BigDecimal salary;
	
	private Date doj;
	
	private List<Skill> skills;
	
	private Skill primarySkill;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Skill getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(Skill primarySkill) {
		this.primarySkill = primarySkill;
	}

}
