/**
 * 
 */
package com.openappengine.facade.ad;

import java.util.List;

import com.openappengine.model.ad.ADTable;
import com.openappengine.service.IApplicationDictionaryService;

/**
 * @author hrishi
 *
 */
public class ApplicationDictionaryFacadeImpl implements
		ApplicationDictionaryFacade {
	
	private IApplicationDictionaryService applicationDictionaryService;

	/* (non-Javadoc)
	 * @see com.openappengine.facade.ad.ApplicationDictionaryFacade#listAllApplicationTableNames()
	 */
	@Override
	public List<String> listAllApplicationTableNames() {
		return applicationDictionaryService.listApplicationTableNames();
	}

	/* (non-Javadoc)
	 * @see com.openappengine.facade.ad.ApplicationDictionaryFacade#listAllApplicationTableColumnNames(java.lang.String)
	 */
	@Override
	public List<String> listAllApplicationTableColumnNames(String tableName) {
		return applicationDictionaryService.getApplicationColumns(tableName);
	}

	/* (non-Javadoc)
	 * @see com.openappengine.facade.ad.ApplicationDictionaryFacade#addADTable(com.openappengine.model.ad.ADTable)
	 */
	@Override
	public void addADTable(ADTable adTable) {
		// TODO Auto-generated method stub
	}

	public void setApplicationDictionaryService(
			IApplicationDictionaryService applicationDictionaryService) {
		this.applicationDictionaryService = applicationDictionaryService;
	}

}
