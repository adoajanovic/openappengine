/**
 * 	Audit Class to be Embedded in other entities
 */
package com.openappengine.repository.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author hrishi
 *
 */
@Embeddable
public class AuditInfo implements Serializable{

	private static final long serialVersionUID = -5203921084465342812L;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="dtAdded",nullable=false)
	private Date dtAdded = new Date();
	
	@Column(name="addedBy",nullable=false)
	private String addedBy;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="dtLastModif",nullable=true)
	private Date dtLastModif = new Date();
	
	@Column(name="lastModifBy",nullable=true)
	private String lastModifBy;

	public AuditInfo(){
	}
	
	public AuditInfo(Date dtAdded, String addedBy, Date dtLastModif,
			String lastModifBy) {
		super();
		this.dtAdded = dtAdded;
		this.addedBy = addedBy;
		this.dtLastModif = dtLastModif;
		this.lastModifBy = lastModifBy;
	}

	/**
	 * @return the dtAdded
	 */
	public Date getDtAdded() {
		return dtAdded;
	}

	/**
	 * @param dtAdded the dtAdded to set
	 */
	public void setDtAdded(Date dtAdded) {
		this.dtAdded = dtAdded;
	}

	/**
	 * @return the addedBy
	 */
	public String getAddedBy() {
		return addedBy;
	}

	/**
	 * @param addedBy the addedBy to set
	 */
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	/**
	 * @return the dtLastModif
	 */
	public Date getDtLastModif() {
		return dtLastModif;
	}

	/**
	 * @param dtLastModif the dtLastModif to set
	 */
	public void setDtLastModif(Date dtLastModif) {
		this.dtLastModif = dtLastModif;
	}

	/**
	 * @return the lastModifBy
	 */
	public String getLastModifBy() {
		return lastModifBy;
	}

	/**
	 * @param lastModifBy the lastModifBy to set
	 */
	public void setLastModifBy(String lastModifBy) {
		this.lastModifBy = lastModifBy;
	}
	
	

}
