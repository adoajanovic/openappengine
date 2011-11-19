/**
 * 
 */
package com.openappengine.service.impl;

import java.util.List;

import com.openappengine.model.ad.ADTable;
import com.openappengine.repository.ApplicationDictionaryRepository;
import com.openappengine.service.IApplicationDictionaryService;

/**
 * @author hrishi
 *
 */
public class ApplicationDictionaryServiceImpl implements
		IApplicationDictionaryService {
	
	private ApplicationDictionaryRepository applicationDictionaryRepository;

	/* (non-Javadoc)
	 * @see com.openappengine.service.IApplicationDictionaryService#addApplicationDictionaryTable(com.openappengine.model.ad.ADTable)
	 */
	@Override
	public void addApplicationDictionaryTable(ADTable adTable) {
		if(adTable == null) {
			return;
		}
		applicationDictionaryRepository.store(adTable);
	}

	/* (non-Javadoc)
	 * @see com.openappengine.service.IApplicationDictionaryService#getApplicationTables()
	 */
	@Override
	public List<String> listApplicationTableNames() {
		List<String> applicationTableNames = applicationDictionaryRepository.listAllApplicationTableNames();
		return applicationTableNames;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.service.IApplicationDictionaryService#getApplicationColumns(java.lang.String)
	 */
	@Override
	public List<String> getApplicationColumns(String tableName) {
		List<String> columns = applicationDictionaryRepository.listAllColumns(tableName);
		return columns;
	}

	public void setApplicationDictionaryRepository(
			ApplicationDictionaryRepository applicationDictionaryRepository) {
		this.applicationDictionaryRepository = applicationDictionaryRepository;
	}

}
