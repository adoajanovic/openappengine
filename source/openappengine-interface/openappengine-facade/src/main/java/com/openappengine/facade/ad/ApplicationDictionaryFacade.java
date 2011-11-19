/**
 * 
 */
package com.openappengine.facade.ad;

import java.util.List;

import com.openappengine.model.ad.ADTable;

/**
 * @author hrishi
 *
 */
public interface ApplicationDictionaryFacade {
	
	public List<String> listAllApplicationTableNames();
	
	public List<String> listAllApplicationTableColumnNames(String tableName);
	
	public void addADTable(ADTable adTable);

}
