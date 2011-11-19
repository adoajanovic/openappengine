/**
 * 
 */
package com.openappengine.facade.ad;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.ad.dto.ADColumnDTO;
import com.openappengine.facade.ad.dto.ADTableDTO;
import com.openappengine.facade.ad.dto.assembler.ADTableDTOAssembler;
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
	public List<ADTableDTO> listAllApplicationTableNames() {
		List<String> tableNames = applicationDictionaryService.listApplicationTableNames();
		List<ADTableDTO> adTableDTOs = new ArrayList<ADTableDTO>();
		if(tableNames != null && !tableNames.isEmpty()) {
			for (String tableName : tableNames) {
				ADTableDTO adTableDTO = new ADTableDTO(tableName);
				adTableDTOs.add(adTableDTO);
			}
		}
		return adTableDTOs;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.facade.ad.ApplicationDictionaryFacade#listAllApplicationTableColumnNames(java.lang.String)
	 */
	@Override
	public List<ADColumnDTO> listAllApplicationTableColumnNames(String tableName) {
		List<String> applicationColumns = applicationDictionaryService.getApplicationColumns(tableName);
		List<ADColumnDTO> adColumnDTOs = new ArrayList<ADColumnDTO>();
		if(applicationColumns != null && !applicationColumns.isEmpty()) {
			for (String applicationColumnName : applicationColumns) {
				adColumnDTOs.add(new ADColumnDTO(applicationColumnName));
			}
		}
		return adColumnDTOs;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.facade.ad.ApplicationDictionaryFacade#addADTable(com.openappengine.model.ad.ADTable)
	 */
	@Override
	public void addADTable(ADTableDTO adTableDTO) {
		applicationDictionaryService.addApplicationDictionaryTable(new ADTableDTOAssembler().fromDTO(adTableDTO));
	}

	public void setApplicationDictionaryService(
			IApplicationDictionaryService applicationDictionaryService) {
		this.applicationDictionaryService = applicationDictionaryService;
	}

}
