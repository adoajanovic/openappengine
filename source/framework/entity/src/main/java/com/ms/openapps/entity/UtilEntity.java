/**
 * 
 */
package com.ms.openapps.entity;

/**
 * @author hrishi
 *
 */
public class UtilEntity {

	private static final String DAO_NAME_SUFFIX = "Dao";
	
	private static final String DELEGATOR_NAME_SUFFIX = "Delegator";
	
	public static String getDelegatorNamefromDaoName(String daoName) {
		String delegatorName = daoName.substring(0, daoName.indexOf(DAO_NAME_SUFFIX));
		delegatorName += DELEGATOR_NAME_SUFFIX;
		return delegatorName; 
	}
	
	public static String getDaoNamefromDelegatorName(String delegatorName) {
		String daoName = delegatorName.substring(0, delegatorName.indexOf(DELEGATOR_NAME_SUFFIX));
		daoName += DAO_NAME_SUFFIX;
		return daoName; 
	}
	
}
