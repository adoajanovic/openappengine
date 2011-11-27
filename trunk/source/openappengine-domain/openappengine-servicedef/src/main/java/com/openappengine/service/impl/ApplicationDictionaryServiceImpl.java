/**
 * 
 */
package com.openappengine.service.impl;

import java.util.List;

import com.openappengine.model.ad.ADColumn;
import com.openappengine.model.ad.ADDataList;
import com.openappengine.model.ad.ADTable;
import com.openappengine.repository.ADDataListRepository;
import com.openappengine.repository.ADTableRepository;
import com.openappengine.service.IApplicationDictionaryService;

/**
 * @author hrishi
 *
 */
public class ApplicationDictionaryServiceImpl implements IApplicationDictionaryService {
	
	private ADTableRepository adTableRepository;
	
	private ADDataListRepository adDataListRepository;

	/* (non-Javadoc)
	 * @see com.openappengine.service.IApplicationDictionaryService#addApplicationDictionaryTable(com.openappengine.model.ad.ADTable)
	 */
	public void addApplicationDictionaryTable(ADTable adTable) {
		if(adTable == null) {
			return;
		}
		adTableRepository.store(adTable);
	}

	/* (non-Javadoc)
	 * @see com.openappengine.service.IApplicationDictionaryService#getApplicationTables()
	 */
	public List<String> listApplicationTableNames() {
		List<String> applicationTableNames = adTableRepository.listAllApplicationTableNames();
		return applicationTableNames;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.service.IApplicationDictionaryService#getApplicationColumns(java.lang.String)
	 */
	public List<ADColumn> getApplicationColumns(String tableName) {
		List<ADColumn> columns = adTableRepository.listAllColumns(tableName);
		return columns;
	}

	public void setApplicationDictionaryRepository(
			ADTableRepository aDTableRepository) {
		this.adTableRepository = aDTableRepository;
	}

	public ADTable getAdTable(String adTableName) {
		ADTable adTable = adTableRepository.getAdTable(adTableName);
		return adTable;
	}
	
	public List<ADDataList> listADDataList(String type) {
	    return this.adDataListRepository.listADDataList(type);
	}

	public ADTableRepository getAdTableRepository() {
	    return adTableRepository;
	}

	public void setAdTableRepository(ADTableRepository adTableRepository) {
	    this.adTableRepository = adTableRepository;
	}

	public ADDataListRepository getAdDataListRepository() {
	    return adDataListRepository;
	}

	public void setAdDataListRepository(ADDataListRepository adDataListRepository) {
	    this.adDataListRepository = adDataListRepository;
	}

}
