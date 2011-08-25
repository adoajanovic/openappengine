/**
 *  Represents a CacheConfigEntity Item
 */
package com.ms.openapps.cache;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class CacheConfigEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private Class<?> entity;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the entity
	 */
	public Class<?> getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(Class<?> entity) {
		this.entity = entity;
	}

	public CacheConfigEntity(){
	}
	
	public CacheConfigEntity(String id, Class<?> entity) {
		super();
		this.id = id;
		this.entity = entity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CacheConfigEntity other = (CacheConfigEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CacheConfigEntity [id=" + id + ", entity=" + entity + "]";
	}
}
