/**
 * 
 */
package com.ms.openapps.entity.dao;

import java.util.Map;

/**
 * @author hrishi
 *
 */
public class DaoFactory {
	
	private Map<String, ? extends IGenericDao> daoMap;
	
	public IGenericDao getGenericDao(String daoName) {
		if(!daoMap.containsKey(daoName)) {
			return null;
		}
		return daoMap.get(daoName);
	}
	/**
	 * @param daoMap the daoMap to set
	 */
	public void setDaoMap(Map<String, ? extends IGenericDao> daoMap) {
		this.daoMap = daoMap;
	}

	public Map<String,? extends IGenericDao> getDaoMap() {
		return daoMap;
	}
	
}