/**
 * 
 */
package com.openappengine.service;

import java.util.List;

import com.openappengine.model.ad.ADColumn;
import com.openappengine.model.ad.ADTable;

/**
 * @author hrishi
 *
 */
public interface IApplicationDictionaryService {
	
	/**
	 * Add Application Dictionary Table.
	 * @param adTable
	 */
	public void addApplicationDictionaryTable(ADTable adTable);
	
	/**
	 * List of all ADColumn for a given table name.
	 * @param tableName
	 * @return List of {@link ADColumn}
	 */
	public List<String> getApplicationColumns(String tableName);

	/**
	 * List all the Application Table Names.
	 * @return
	 */
	List<String> listApplicationTableNames();

}
