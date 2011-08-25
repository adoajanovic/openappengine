/**
 * 	PK for the GenericEntity
 */
package com.ms.openapps.entity;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class GenericEntityPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Object pk;

	public GenericEntityPK(Object pk) {
		this.pk = pk;
	}
	
	/**
	 * @param pk the pk to set
	 */
	public void setPk(Object pk) {
		this.pk = pk;
	}

	/**
	 * @return the pk
	 */
	public Object getPk() {
		return pk;
	}

}