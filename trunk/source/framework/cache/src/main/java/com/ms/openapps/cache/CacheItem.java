/**
 * 
 */
package com.ms.openapps.cache;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hrishi
 *
 */
public class CacheItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* Cached Object*/
	private Object cachedObject;
	
	/* Fetch Time*/
	private Date fetchTimeStamp = new Date();

	/**
	 * @return the fetchTimeStamp
	 */
	public Date getFetchTimeStamp() {
		return fetchTimeStamp;
	}

	/**
	 * @param fetchTimeStamp the fetchTimeStamp to set
	 */
	public void setFetchTimeStamp(Date fetchTimeStamp) {
		this.fetchTimeStamp = fetchTimeStamp;
	}

	public CacheItem(Object value) {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CacheItem [value=" + cachedObject
				+ ", fetchTimeStamp=" + fetchTimeStamp + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fetchTimeStamp == null) ? 0 : fetchTimeStamp.hashCode());
		result = prime * result + ((cachedObject == null) ? 0 : cachedObject.hashCode());
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
		CacheItem other = (CacheItem) obj;
		if (fetchTimeStamp == null) {
			if (other.fetchTimeStamp != null)
				return false;
		} else if (!fetchTimeStamp.equals(other.fetchTimeStamp))
			return false;
		if (cachedObject == null) {
			if (other.cachedObject!= null)
				return false;
		} else if (!cachedObject.equals(other.cachedObject))
			return false;
		return true;
	}

}
