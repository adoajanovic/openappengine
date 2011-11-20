/**
 * 
 */
package com.openappengine.facade.ad;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.ad.dto.ADColumnDTO;
import com.openappengine.facade.ad.dto.ADTableDTO;
import com.openappengine.facade.ad.dto.assembler.ADColumnDTOAssembler;
import com.openappengine.facade.ad.dto.assembler.ADTableDTOAssembler;
import com.openappengine.model.ad.ADColumn;
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
		List<ADColumn> applicationColumns = applicationDictionaryService.getApplicationColumns(tableName);
		
		List<ADColumnDTO> adColumnDTOs = new ArrayList<ADColumnDTO>();
		if(applicationColumns != null && !applicationColumns.isEmpty()) {
			for (ADColumn adColumn : applicationColumns) {
				adColumnDTOs.add(new ADColumnDTOAssembler().toDTO(adColumn));
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

	@Override
	public ADTableDTO getAdTableDTO(String tableName) {
		ADTable adTable = applicationDictionaryService.getAdTable(tableName);
		return new ADTableDTOAssembler().toDTO(adTable);
	}

}
