/**
 * 
 */
package com.openappengine.web.mvc.ad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.openappengine.facade.ad.ApplicationDictionaryFacade;
import com.openappengine.facade.ad.dto.ADColumnDTO;
import com.openappengine.facade.ad.dto.ADTableDTO;
import com.openappengine.facade.context.FacadeContext;
import com.openappengine.web.mvc.BaseWebController;

/**
 * @author hrishi
 * 
 */
public class ApplicationDictionaryControllerImpl extends BaseWebController
		implements ApplicationDictionaryController,Serializable {

	private static final long serialVersionUID = 1L;

	private ApplicationDictionaryFacade applicationDictionaryFacade;

	private ADTableBean adTableBean;

	private ADTableDTO selectedADTableDTO;

	private List<SelectItem> adTableDTOs = new ArrayList<SelectItem>();

	private List<ADColumnBean> adColumns = new ArrayList<ADColumnBean>();

	public ApplicationDictionaryControllerImpl() {
		this.applicationDictionaryFacade = FacadeContext.getApplicationDictionaryFacade();
		logger.info("ApplicationDictionaryController Initialized.");
	}

	public String adTableSelected() {
		final String tableName = adTableBean.getTableName();
		populateADColumns(tableName);
		return null;
	}

	private void populateADColumns(final String tableName) {
		List<ADColumnDTO> adColumnDTOs = applicationDictionaryFacade.listAllApplicationTableColumnNames(tableName);
		getAdColumns().clear();
		if(adColumnDTOs != null && !adColumnDTOs.isEmpty()) {
			for (ADColumnDTO adColumnDTO : adColumnDTOs) {
				ADColumnBean adColumnBean = new ADColumnBean();
				adColumnBean.setColumnName(adColumnDTO.getColumnName());
				adColumnBean.setChecked(false);
				getAdColumns().add(adColumnBean);
			}
		}
	}

	public ADTableBean getAdTableBean() {
		return adTableBean;
	}

	public void setAdTableBean(ADTableBean adTableBean) {
		this.adTableBean = adTableBean;
	}

	public List<SelectItem> getAdTableDTOs() {
		List<ADTableDTO> applicationTableNames = applicationDictionaryFacade
				.listAllApplicationTableNames();
		if (applicationTableNames != null && !applicationTableNames.isEmpty()) {
			for (ADTableDTO adTableDTO : applicationTableNames) {
				adTableDTOs.add(new SelectItem(adTableDTO.getTableName(), adTableDTO.getTableName()));
			}
		}
		return adTableDTOs;
	}

	public String save() {
		return null;
	}
	
	
	public void setAdTableDTOs(List<SelectItem> adTableDTOs) {
		this.adTableDTOs = adTableDTOs;
	}

	public ADTableDTO getSelectedADTableDTO() {
		return selectedADTableDTO;
	}

	public void setSelectedADTableDTO(ADTableDTO selectedADTableDTO) {
		this.selectedADTableDTO = selectedADTableDTO;
	}

	public List<ADColumnBean> getAdColumns() {
		return adColumns;
	}

	public void setAdColumns(List<ADColumnBean> adColumns) {
		this.adColumns = adColumns;
	}
	
}
