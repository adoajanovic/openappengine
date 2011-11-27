/**
 * 
 */
package com.openappengine.facade.ad;

import java.util.List;

import com.openappengine.facade.ad.dto.ADColumnDTO;
import com.openappengine.facade.ad.dto.ADListItemDTO;
import com.openappengine.facade.ad.dto.ADTableDTO;

/**
 * @author hrishi
 *
 */
public interface ApplicationDictionaryFacade {
	
	public List<ADTableDTO> listAllApplicationTableNames();
	
	public List<ADColumnDTO> listAllApplicationTableColumnNames(String tableName);
	
	public void addADTable(ADTableDTO adTable);
	
	public ADTableDTO getAdTableDTO(String tableName);
	
	public List<ADListItemDTO> getADListItems(String type);

}
